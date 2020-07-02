package com.kosmo59.yoginaegym.member;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/* 메인 -> 회원버튼 클릭 -> 회원 로그인 화면 */
public class MemLoginActivity extends AppCompatActivity {

    private EditText et_memLoginId, et_memLoginPw;
    private Button btn_loginMem, btn_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_login);

        et_memLoginId = findViewById(R.id.et_memLoginId);
        et_memLoginPw = findViewById(R.id.et_memLoginPw);
        btn_loginMem = findViewById(R.id.btn_loginMem);
        btn_join = findViewById(R.id.btn_join);

        //로그인 버튼 -> 회원 메인 화면 이동
        btn_loginMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemLoginActivity.this, MemMainActivity.class);
                startActivity(intent);
            }
        });

        //회원가입 버튼 -> 회원가입 화면 이동
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemLoginActivity.this, MemJoinActivity.class);
                startActivity(intent);
            }
        });

    }

}
