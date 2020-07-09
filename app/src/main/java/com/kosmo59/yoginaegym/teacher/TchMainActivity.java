package com.kosmo59.yoginaegym.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.ContentActivity;
import com.kosmo59.yoginaegym.member.MemChatListActivity;
import com.kosmo59.yoginaegym.member.MemMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
                        break;
                    case R.id.bot_nav_qr:
                        break;
                    case R.id.bot_nav_cont:
                        Intent intent_cont = new Intent(TchMainActivity.this, ContentActivity.class);
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
