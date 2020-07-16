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
    AppVO tvo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_login);
        tvo = (AppVO) getApplicationContext();
        btn_loginTch = findViewById(R.id.btn_loginTch);
        et_tchLoginId = findViewById(R.id.et_tchLoginId);
        et_tchLoginPw = findViewById(R.id.et_tchLoginPw);

        btn_loginTch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tchId = et_tchLoginId.getText().toString();
                String tchPw = et_tchLoginPw.getText().toString();
                //채팅
                tvo.setTchId(et_tchLoginId.getText().toString());
                tvo.setTchNum(et_tchLoginPw.getText().toString());
                String tchName = "나강사";
                tvo.setTchName(tchName);
                tvo.setRoomName2(tchName);
                tvo.setMsgSendName(tchName);
                tvo.setMsgSendId(tchId);
                Intent intent = new Intent(TchLoginActivity.this, TchMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
