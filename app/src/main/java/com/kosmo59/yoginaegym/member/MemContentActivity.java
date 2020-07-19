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
import android.widget.ListView;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemContentActivity extends AppCompatActivity {
    private AppVO vo = null;
    ImageView iv_memQr = null;
    TextView tv_memQrName=null;

    public final String MEM_CONT_LOG = "MemContentActivity";

    //이미지 버튼
    private ImageButton ib_emptyHeart;
    private ListView lv_mem_cont;

    private TextView tv_contLike;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        vo = (AppVO) getApplicationContext();

        Log.i(MEM_CONT_LOG, "호출 성공");
        String reqUrl = "android/jsonContentsList.gym";
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
        List<Map<String, Object>> contList = new ArrayList<>();
        Map<String, Object> contMap = null;
        if (result != null) {
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    contMap = new HashMap<>();
                    jsonObject = jsonArray.getJSONObject(i);
                    contMap.put("CONT_CONT", jsonObject.getString("CONT_CONT"));
                    contMap.put("CONT_SEQ", jsonObject.getString("CONT_SEQ"));
                    contMap.put("CONT_LIKE", jsonObject.getString("CONT_LIKE"));
                    contMap.put("CONT_DATE", jsonObject.getString("CONT_DATE"));
                    contMap.put("FILE_SEQ", jsonObject.getString("FILE_SEQ"));
                    contMap.put("WHO", jsonObject.getString("WHO"));
                    contMap.put("CONT_TIME", jsonObject.getString("CONT_TIME"));
                    contList.add(contMap);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MemContentAdapter memContentAdapter = new MemContentAdapter(getApplicationContext(), R.layout.mem_content_item, contList);
            lv_mem_cont = findViewById(R.id.lv_mem_cont);
            lv_mem_cont.setAdapter(memContentAdapter);

            ib_emptyHeart = findViewById(R.id.ib_emptyHeart1);

            //////////////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////
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

}
