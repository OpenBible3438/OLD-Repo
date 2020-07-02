package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* 메인 -> 강사 버튼 클릭 -> 강사 로그인 화면 */
public class TchLoginActivity extends AppCompatActivity {

    private Button btn_loginTch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_login);

        btn_loginTch = findViewById(R.id.btn_loginTch);
        btn_loginTch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TchLoginActivity.this, TchMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
