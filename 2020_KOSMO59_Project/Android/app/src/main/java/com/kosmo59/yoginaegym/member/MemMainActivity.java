package com.kosmo59.yoginaegym.member;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.gym.GymSearchActivity;

import android.app.Dialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MemMainActivity extends AppCompatActivity {

    private Button btn_memGymSearch, btn_memInfo, btn_memTimeTable, btn_memClass;

    private AppVO vo = null;
    ImageView iv_memQr = null;
    TextView tv_memQrName=null;
    TextView tv_memNumberText=null;
    TextView tv_memQrNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_main);

        vo = (AppVO) getApplicationContext();

        btn_memGymSearch = findViewById(R.id.btn_memGymSearch);
        btn_memInfo = findViewById(R.id.btn_memInfo);
        btn_memTimeTable = findViewById(R.id.btn_memTimeTable);
        btn_memClass = findViewById(R.id.btn_memClass);


        btn_memGymSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemMainActivity.this, GymSearchActivity.class);
                startActivity(intent);
            }
        });
        btn_memInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //??? ?????? ????????? ???
                Intent intent = new Intent(MemMainActivity.this, MemProfileActivity.class);
                startActivity(intent);
            }
        });
        btn_memTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //????????? ????????? ???
                Intent intent = new Intent(MemMainActivity.this, MemTimeTableActivity.class);
                startActivity(intent);
            }
        });
        btn_memClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //??? ?????? ????????? ???
                Intent intent = new Intent(MemMainActivity.this, MemclassActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottom = findViewById(R.id.bottom_nav);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        //MainActivity????????? ?????? ??? ?????? ?????? ????????????
                        //MemMainActivity.super.onBackPressed();
                        break;
                    case R.id.bot_nav_qr:
                        //??????????????? ?????????
                        final Dialog dlg = new Dialog(MemMainActivity.this);
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dlg.setContentView(R.layout.dialog_mem_qr);
                        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
                        //QR ?????? ??????
                        //String data = vo.getMemberId(); //mem_id??? QR?????? ??????
                        int data = vo.getMem_no();
                        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                        try {
                            BitMatrix bitMatrix = multiFormatWriter.encode(Integer.toString(data), BarcodeFormat.QR_CODE, 300,300);
                            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                            Log.i("QR Make", "????????? QR Bitmap : "+bitmap.toString());
                            iv_memQr = dlg.findViewById(R.id.iv_memQr);
                            tv_memQrName = dlg.findViewById(R.id.tv_memQrName);
                            iv_memQr.setImageBitmap(bitmap); //???????????? QR?????? ?????????
                            tv_memQrName.setText(vo.getMemberName()+" ?????????");
                            tv_memNumberText= dlg.findViewById(R.id.tv_memNumberText);
                            tv_memNumberText.setText("????????????");
                            tv_memQrNumber = dlg.findViewById(R.id.tv_memQrNumber);
                            tv_memQrNumber.setText(vo.getMem_no()+"");
                        }catch (Exception e){
                            Log.i("QR Make", e.toString());
                        }
                        dlg.show();
                        break;
                    case R.id.bot_nav_cont:
                        Intent intent_cont = new Intent(MemMainActivity.this, MemContentActivity.class);
                        startActivity(intent_cont);
                        break;
                    case R.id.bot_nav_msg:
                        Intent intent_msg = new Intent(MemMainActivity.this, MemChatListActivity.class);
                        startActivity(intent_msg);
                        break;

                }
                return false;
            }
        });
    }

}
