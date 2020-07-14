package com.kosmo59.yoginaegym.member;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/* 메인 -> 회원버튼 클릭 -> 회원 로그인 화면 */
public class MemLoginActivity extends AppCompatActivity {
    private final String MEMBER_LOGIN = "MemberLoginActivity";
    private TextInputEditText et_memLoginId, et_memLoginPw;
    private Button btn_loginMem, btn_join;
    private TextView ham_name;

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
                Map<String, String> loginMap = new HashMap<>();
                String id = et_memLoginId.getText().toString();
                String pw = et_memLoginPw.getText().toString();
                String send = "android/jsonMemberLogin.gym";
                loginMap.put("mem_id", id);
                loginMap.put("mem_pw", pw);
                loginMap.put("gym_no", "1");///////바꿀 코드

                //채팅 변수 담기
                AppVO vo = (AppVO) getApplicationContext();

                String result = null;
                JSONObject jsonObject = null;
                JSONArray jsonArray = null;
                try {
                    TomcatSend tomcatSend = new TomcatSend();
                    result = tomcatSend.execute(send, loginMap.toString()).get();
                    jsonArray = new JSONArray(result);
                } catch (Exception e){
                    Log.i(MEMBER_LOGIN, "Exception : "+e.toString());
                }
                Log.i(MEMBER_LOGIN, "톰캣서버에서 읽어온 정보"+result);

                if(result != null){
                    try {
                        for (int i=0; i<jsonArray.length(); i++){
                            jsonObject = jsonArray.getJSONObject(i);
                            vo.setMemberId(id);
                            vo.setMemberName(jsonObject.getString("MEM_NAME"));
                            vo.setRoomName1(jsonObject.getString("MEM_NAME"));
                            vo.setMemberNickname(jsonObject.getString("MEM_NICKNAME"));
                            vo.setMem_no(jsonObject.getInt("MEM_NO"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MemLoginActivity.this, vo.getMemberId()+"님 로그인 성공", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MemLoginActivity.this, "이름은 "+vo.getMemberName()+"닉네임은 "+vo.getMemberNickname(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MemLoginActivity.this, MemMainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MemLoginActivity.this, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show();
                }

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
