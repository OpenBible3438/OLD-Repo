package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* 메인 -> 강사 버튼 클릭 -> 강사 로그인 화면 */
public class TchLoginActivity extends AppCompatActivity {

    private Button btn_loginTch;
    private TextInputEditText et_tchLoginId, et_tchLoginPw;
    static AppVO tvo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_login);

        btn_loginTch = findViewById(R.id.btn_loginTch);
        btn_loginTch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvo = (AppVO) getApplicationContext();
                et_tchLoginId = findViewById(R.id.et_tchLoginId);
                et_tchLoginPw = findViewById(R.id.et_tchLoginPw);
                String tchId = et_tchLoginId.getText().toString();
                String tchPw = et_tchLoginPw.getText().toString();
                //채팅
                tvo.setTchId(tchId);
                tvo.setTchNum(tchPw);
                String tchName = "나강사";
                tvo.setTchName(tchName);
                tvo.setRoomName2(tchName);

                Intent intent = new Intent(TchLoginActivity.this, TchMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
