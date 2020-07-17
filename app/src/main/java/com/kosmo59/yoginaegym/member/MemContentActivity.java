package com.kosmo59.yoginaegym.member;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;
import com.kosmo59.yoginaegym.gym.GymNoticeAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemContentActivity extends AppCompatActivity {
    private AppVO vo = null;
    ImageView iv_memQr = null;
    TextView tv_memQrName=null;

    public final String MEM_CONT_LOG = "MemContentActivity";

    //1이면 눌려있을 때, 0이면 안 눌려있을 때
    private int check_num = 0;
    //이미지 버튼
    private ImageButton ib_emptyHeart;

    //좋아요 수
    private int like=0;
    private TextView tv_contLike;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        vo = (AppVO) getApplicationContext();

        Log.i(MEM_CONT_LOG, "호출 성공");
        String reqUrl = "android/jsonGymNoticeList.gym";
        Map<String, Object> pMap = new HashMap<>();
        //pMap.put("gym_no", vo.gym_no);
        String result = null;
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
            jsonArray = new JSONArray(result);
        } catch (Exception e) {
            Log.i(MEM_CONT_LOG, "Exception : " + e.toString());
        }
        Log.i(MEM_CONT_LOG, "톰캣서버에서 읽어온 정보" + result);

        if (result != null) {
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    vo.setMemberName(jsonObject.getString("MEM_NAME"));
                    vo.setRoomName1(jsonObject.getString("MEM_NAME"));
                    vo.setMsgSendName(jsonObject.getString("MEM_NAME"));
                    vo.setMemberNickname(jsonObject.getString("MEM_NICKNAME"));
                    vo.setMem_no(jsonObject.getInt("MEM_NO"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            /* 하단바 추가 */
            BottomNavigationView bottom = findViewById(R.id.bottom_nav);
            bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.bot_nav_home:
                            MemContentActivity.super.onBackPressed();
                            break;
                        case R.id.bot_nav_qr:
                            //다이얼로그 초기화
                            final Dialog dlg = new Dialog(MemContentActivity.this);
                            dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dlg.setContentView(R.layout.dialog_mem_qr);
                            WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                            params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                            dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
                            //QR 코드 생성
                            String data = vo.getMemberId(); //mem_id로 QR코드 생성
                            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                            try {
                                BitMatrix bitMatrix = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 300, 300);
                                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                                Log.i("QR Make", "생성된 QR Bitmap : " + bitmap.toString());
                                iv_memQr = dlg.findViewById(R.id.iv_memQr);
                                tv_memQrName = dlg.findViewById(R.id.tv_memQrName);
                                iv_memQr.setImageBitmap(bitmap); //만들어진 QR코드 붙이기
                                tv_memQrName.setText(vo.getMemberName() + " 회원님");
                            } catch (Exception e) {
                                Log.i("QR Make", e.toString());
                            }
                            dlg.show();
                            break;
                        case R.id.bot_nav_cont:
                            //컨첸츠에서 컨텐츠는 아무것도 xxx
                            break;
                        case R.id.bot_nav_msg:
                            Intent intent_msg = new Intent(MemContentActivity.this, MemChatListActivity.class);
                            startActivity(intent_msg);
                            MemContentActivity.this.finish();
                            break;

                    }
                    return false;
                }
            });

        }
    }

    public void cont_clickHeart(View view) {
        ib_emptyHeart = findViewById(view.getId());
        //0이면 눌려있지 않을 때 => 빈 하트
        if(check_num == 0){
            //눌려있지 않은 상태에서 눌렸으면 1로 바꾸어주기 => 눌린상태
            check_num = 1;
            ib_emptyHeart.setSelected(true); //이미지버튼이 선택된 상태니까 true
            ib_emptyHeart.setImageResource(R.drawable.cont_heart); //눌렸으니까 색칠되어있는 하트 이미지로 변경
            like+=1;
            //tv_contLike.setText(like+"명이 좋아합니다");
        }
        else{  //이미지 버튼이 눌려있을 때 (check_num == 1)인 상태
            check_num = 0; //눌려있을 때 다시 누르면 안 눌린 상태로 돌려야되니까 check_num=0으로
            ib_emptyHeart.setSelected(false); //이미지 버튼이 선택 안 되어있으니까 상태 false
            ib_emptyHeart.setImageResource(R.drawable.cont_heart_empty); //다시 눌리지 않은 상태니까 이미지를 빈 하트 이미지로 변경
            like-=1;
            //tv_contLike.setText(like+"명이 좋아합니다");
        }
    }
}
