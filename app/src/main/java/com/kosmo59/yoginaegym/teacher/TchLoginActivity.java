package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;
import com.kosmo59.yoginaegym.member.MemLoginActivity;
import com.kosmo59.yoginaegym.member.MemMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
                Log.i("TchLoginActivity", "로그인 버튼 클릭");
                Map<String, String> loginMap = new HashMap<>();
                String id = et_tchLoginId.getText().toString();
                String pw = et_tchLoginPw.getText().toString();
                String send = "android/jsonTeacherLogin.gym";
                loginMap.put("tch_id", id);
                loginMap.put("tch_pw", pw);
                //loginMap.put("gym_no", "1");///////바꿀 코드

                String result = null;
                JSONObject jsonObject = null;
                JSONArray jsonArray = null;
                try {
                    TomcatSend tomcatSend = new TomcatSend();
                    result = tomcatSend.execute(send, loginMap.toString()).get();
                    jsonArray = new JSONArray(result);
                } catch (Exception e){
                    Log.i("TchLoginActivity", "Exception : "+e.toString());
                }
                Log.i("TchLoginActivity", "톰캣서버에서 읽어온 정보"+result);

                if(result != null){
                    try {
                        for (int i=0; i<jsonArray.length(); i++){
                            jsonObject = jsonArray.getJSONObject(i);
                            //if(jsonObject.getString("confirm") != null) {
                            if(!(jsonObject.isNull("confirm"))) {
                                if("아이디".equals(jsonObject.getString("confirm"))) {
                                    Toast.makeText(TchLoginActivity.this, "아이디가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                                    break;
                                } else if("비밀번호".equals(jsonObject.getString("confirm"))) {
                                    Toast.makeText(TchLoginActivity.this, "비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show();
                                    break;
                                }
                            } else {
                                tvo.setTchId(id);
                                tvo.setMsgSendId(id);
                                tvo.setTchNum(jsonObject.getString("TCH_NO")); //강사번호
                                String tchName = jsonObject.getString("TCH_NAME");
                                tvo.setTchName(tchName);
                                tvo.setRoomName2(tchName);
                                tvo.setMsgSendName(tchName);
                                Toast.makeText(TchLoginActivity.this, tvo.getTchName()+"님 로그인 성공", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(TchLoginActivity.this, TchMainActivity.class);
                                startActivity(intent);
                                break;
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(TchLoginActivity.this, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show();
                }






                //채팅

            }
        });
    }
}
