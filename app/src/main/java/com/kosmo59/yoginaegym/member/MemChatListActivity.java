package com.kosmo59.yoginaegym.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.Chat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* 회원이 채팅할 강사 리스트 출력 */
public class MemChatListActivity extends AppCompatActivity {

    private CardView cardView;
    static AppVO vo = null;

    ImageView iv_memQr = null;
    TextView tv_memQrName=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_chat_list);

        vo = (AppVO)getApplicationContext();

        cardView = findViewById(R.id.chat_tch1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vo.setRoomName2("나강사");
                Toast.makeText(MemChatListActivity.this, "나강사 강사 선택", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MemChatListActivity.this, Chat.class);
                startActivity(intent);
            }
        });

        /* 하단바 추가 */
        BottomNavigationView bottom = findViewById(R.id.bottom_nav);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        MemChatListActivity.super.onBackPressed();
                        break;
                    case R.id.bot_nav_qr:
                        //다이얼로그 초기화
                        final Dialog dlg = new Dialog(MemChatListActivity.this);
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dlg.setContentView(R.layout.dialog_mem_qr);
                        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
                        //QR 코드 생성
                        String data = vo.getMemberId(); //mem_id로 QR코드 생성
                        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                        try {
                            BitMatrix bitMatrix = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 300,300);
                            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                            Log.i("QR Make", "생성된 QR Bitmap : "+bitmap.toString());
                            iv_memQr = dlg.findViewById(R.id.iv_memQr);
                            tv_memQrName = dlg.findViewById(R.id.tv_memQrName);
                            iv_memQr.setImageBitmap(bitmap); //만들어진 QR코드 붙이기
                            tv_memQrName.setText(vo.getMemberName()+" 회원님");
                        }catch (Exception e){
                            Log.i("QR Make", e.toString());
                        }
                        dlg.show();
                        break;
                    case R.id.bot_nav_cont:
                        Intent intent_cont = new Intent(MemChatListActivity.this, MemContentActivity.class);
                        startActivity(intent_cont);
                        MemChatListActivity.this.finish();
                        break;
                    case R.id.bot_nav_msg:
                        //채팅 리스트에서는 아무것도 xx
                        break;

                }
                return false;
            }
        });


    }

}
