package com.kosmo59.yoginaegym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.kosmo59.yoginaegym.member.MemLoginActivity;
import com.kosmo59.yoginaegym.teacher.TchLoginActivity;

public class MainActivity extends AppCompatActivity {
    MainImageAdapter mainImageAdapter;
    ViewPager vp_main;
    Button btn_mainMem, btn_mainTch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //첫 화면 이미지
        mainImageAdapter = new MainImageAdapter(this);
        vp_main = findViewById(R.id.vp_main);
        vp_main.setAdapter(mainImageAdapter);

        btn_mainMem = findViewById(R.id.btn_mainMem);
        btn_mainTch = findViewById(R.id.btn_mainTch);

        //회원 버튼 눌렀을 때 회원 로그인 화면으로 이동
        btn_mainMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MemLoginActivity.class);
                startActivity(intent);
            }
        });
        //강사 버튼 눌렀을 때 강사 로그인 화면으로 이동
        btn_mainTch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TchLoginActivity.class);
                startActivity(intent);
            }
        });

    }


}
