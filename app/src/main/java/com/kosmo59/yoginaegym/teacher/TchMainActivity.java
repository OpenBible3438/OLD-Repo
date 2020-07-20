package com.kosmo59.yoginaegym.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.gym.GymProfileActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

public class TchMainActivity extends AppCompatActivity {

    private Button btn_moveTchProfile, btn_moveTchCal, btn_moveTchManage;

    ImageView iv_memQr = null;
    TextView tv_memQrName=null;
    TextView tv_memQrNumber=null;
    AppVO vo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_main);

        vo = (AppVO) getApplicationContext();

        btn_moveTchProfile = findViewById(R.id.btn_moveTchProfile);
        btn_moveTchCal = findViewById(R.id.btn_moveTchCal);
        btn_moveTchManage = findViewById(R.id.btn_moveTchManage);

        //강사 프로필 이동
        btn_moveTchProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TchMainActivity.this, TchMyProfileActivity.class);
                startActivity(intent);
            }
        });
        //강사 일정보기 이동
        btn_moveTchCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TchMainActivity.this, TchCalActivity.class);
                startActivity(intent);
            }
        });
        //강사 회원관리 이동
        btn_moveTchManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TchMainActivity.this, TchManageActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottom = findViewById(R.id.bottom_nav);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        //home에서는 아무것도 xx
                        break;
                    case R.id.bot_nav_qr:
                        //다이얼로그 초기화
                        final Dialog dlg = new Dialog(TchMainActivity.this);
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dlg.setContentView(R.layout.dialog_mem_qr);
                        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
                        //QR 코드 생성
                        //String data = vo.getTchId(); //mem_id로 QR코드 생성
                        String data = vo.getTchNum()+","+vo.getTchName(); //QR코드 data
                        try {
                            data = new String(data.getBytes("UTF-8"), "ISO-8859-1");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
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
                        Intent intent_cont = new Intent(TchMainActivity.this, TchContentActivity.class);
                        startActivity(intent_cont);
                        break;
                    case R.id.bot_nav_msg:
                        Intent intent_msg = new Intent(TchMainActivity.this, TchChatListActivity.class);
                        startActivity(intent_msg);
                        break;

                }
                return false;
            }
        });
    }
}
