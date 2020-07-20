package com.kosmo59.yoginaegym.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TchChatListActivity extends AppCompatActivity {
    ImageView iv_memQr = null;
    TextView tv_memQrName=null;
    TextView tv_memQrNumber=null;

    static AppVO vo = null;
    private ListView lv_tch_chat;
    List<Map<String, Object>> chatMemList = null;
    private final String TCH_CHAT_LOG = "TchChatListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_chat_list);

        vo = (AppVO)getApplicationContext();

        Log.i(TCH_CHAT_LOG, "호출 성공");
        String result = null;
        String reqUrl = "android/jsonTchChatMemList.gym"; //전체 회원 조회
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("tch_no",Integer.parseInt(vo.getTchNum()));
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        } catch (Exception e){
            Log.i("TchChatListActivity", "Exception : "+e.toString());
        }
        Log.i("TchChatListActivity", "톰캣서버에서 읽어온 정보 : "+result);

//        if(result != null){
//            Toast.makeText(TchChatListActivity.this, result, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(TchChatListActivity.this, "문제 발생.", Toast.LENGTH_LONG).show();
//        }
        Gson g = new Gson();
        chatMemList = (List<Map<String, Object>>)g.fromJson(result, listType);
        TchChatAdapter tchChatAdapter = new TchChatAdapter(TchChatListActivity.this, R.layout.tch_chat_list_item, chatMemList);
        lv_tch_chat = findViewById(R.id.lv_tch_chat);
        lv_tch_chat.setAdapter(tchChatAdapter);

        /* 하단바 */
        BottomNavigationView bottom = findViewById(R.id.bottom_nav);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        TchChatListActivity.super.onBackPressed();
                        break;
                    case R.id.bot_nav_qr:
                        //다이얼로그 초기화
                        final Dialog dlg = new Dialog(TchChatListActivity.this);
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dlg.setContentView(R.layout.dialog_mem_qr);
                        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
                        //QR 코드 생성
                        String data = vo.getTchId(); //mem_id로 QR코드 생성
                        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                        try {
                            BitMatrix bitMatrix = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 300,300);
                            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                            Log.i("QR Make", "생성된 QR Bitmap : "+bitmap.toString());
                            iv_memQr = dlg.findViewById(R.id.iv_memQr);
                            tv_memQrName = dlg.findViewById(R.id.tv_memQrName);
                            iv_memQr.setImageBitmap(bitmap); //만들어진 QR코드 붙이기
                            tv_memQrName.setText(vo.getTchName()+" 강사님");
                            tv_memQrNumber = dlg.findViewById(R.id.tv_memQrNumber);
                            tv_memQrNumber.setText(vo.getTchNum()+"");
                        }catch (Exception e){
                            Log.i("QR Make", e.toString());
                        }
                        dlg.show();
                        break;
                    case R.id.bot_nav_cont:
                        Intent intent_cont = new Intent(TchChatListActivity.this, TchContentActivity.class);
                        startActivity(intent_cont);
                        TchChatListActivity.this.finish();
                        break;
                    case R.id.bot_nav_msg:
                        //msg xxxxx
                        break;

                }
                return false;
            }
        });


        /*
        어댑터에서  클릭 이벤트 연결해야됨.
        cardView = findViewById(R.id.chat_mem1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vo.getMemberId() != null){
                    vo.setRoomName1(vo.getMemberName());
                    Intent intent = new Intent(TchChatListActivity.this, Chat.class);
                    startActivity(intent);
                }else{
                    vo.setRoomName1("김회원");
                    Intent intent = new Intent(TchChatListActivity.this, Chat.class);
                    startActivity(intent);
                }
                //Toast.makeText(TchChatListActivity.this, "김회원 회원 선택", Toast.LENGTH_SHORT).show();
            }
        });

         */

    }
}
