package com.kosmo59.yoginaegym.member;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatSend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/* 메인 -> 회원버튼 클릭 -> 회원 로그인 화면 */
public class MemLoginActivity extends AppCompatActivity {
    private final String MEMBER_LOGIN = "MemberLoginActivity";
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
                Log.i(MEMBER_LOGIN, "로그인 버튼 클릭");
                //Map<String, String> loginMap = new HashMap<>();
                String id = et_memLoginId.getText().toString();
                String pw = et_memLoginPw.getText().toString();
                //loginMap.put("mem_id", id);
                //loginMap.put("mem_pw", pw);
                String send = "android/jsonMemberLogin.gym";
                String send2 = "{mem_id="+id+"&"+"mem_pw="+pw+"}";
                //톰캣 서버에서 전송한 문자열을 받을 변수
                //로그인 주석처리
                /*
                String result = null;
                try {
                    TomcatSend tomcatSend = new TomcatSend();
                    result = tomcatSend.execute(send, send2).get();
                } catch (Exception e){
                    Log.i(MEMBER_LOGIN, "Exception : "+e.toString());
                }
                Log.i(MEMBER_LOGIN, "톰캣서버에서 읽어온 정보"+result);

                if(result != null){
                    Toast.makeText(MemLoginActivity.this, result+"님 로그인 성공", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MemLoginActivity.this, MemMainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MemLoginActivity.this, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show();
                }

                 */

                Toast.makeText(MemLoginActivity.this, id+"님 로그인 성공", Toast.LENGTH_SHORT).show();
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
