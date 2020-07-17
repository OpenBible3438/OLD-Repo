package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TchMyProfileActivity extends AppCompatActivity {
    private ImageButton icon_close;
    private Button btn_tchMyProfile_upd;
    private Button btn_tchMyProfile_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_my_profile);

        icon_close = findViewById(R.id.icon_close);
        icon_close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"activity_tch_main으로 이동해주세요.", Toast.LENGTH_LONG).show();
                TchMyProfileActivity.super.onBackPressed();
            }
        });


        btn_tchMyProfile_upd = findViewById(R.id.btn_tchMyProfile_upd);
        btn_tchMyProfile_upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"수정 DB연동 해주세요.", Toast.LENGTH_LONG).show();
            }
        });


        btn_tchMyProfile_img = findViewById(R.id.btn_tchMyProfile_img);
        btn_tchMyProfile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"이미지 찾기 해주세요.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
