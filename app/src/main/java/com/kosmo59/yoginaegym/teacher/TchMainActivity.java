package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TchMainActivity extends AppCompatActivity {

    private Button btn_moveTchProfile, btn_moveTchCal, btn_moveTchManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_main);

        btn_moveTchProfile = findViewById(R.id.btn_moveTchProfile);
        btn_moveTchCal = findViewById(R.id.btn_moveTchCal);
        btn_moveTchManage = findViewById(R.id.btn_moveTchManage);

        //강사 프로필 이동
        btn_moveTchProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //강사 일정보기 이동
        btn_moveTchCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    }
}
