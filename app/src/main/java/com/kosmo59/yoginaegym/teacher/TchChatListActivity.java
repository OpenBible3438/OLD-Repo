package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import java.lang.reflect.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TchChatListActivity extends AppCompatActivity {

    static AppVO vo = null;
    private ListView lv_tch_chat;
    List<Map<String, Object>> chatMemList = null;
    private final String TCH_CHAT_LOG = "TchChatListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_chat_list);

        vo = (AppVO)getApplicationContext();

        Log.i(TCH_CHAT_LOG, "호출 성공");
        String result = null;
        String reqUrl = "android/jsonClsMemList.gym"; //수업별 수강생 조회
        Map<String, Object> pMap = new HashMap<>();
        //강사 번호를 넘겨줘야됨. 나강사 번호
        pMap.put("cls_no",2007401);
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);

        if(result != null){
            Toast.makeText(TchChatListActivity.this, result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(TchChatListActivity.this, "문제 발생.", Toast.LENGTH_LONG).show();
        }
        Gson g = new Gson();
        chatMemList = (List<Map<String, Object>>)g.fromJson(result, listType);
        TchChatAdapter tchChatAdapter = new TchChatAdapter(TchChatListActivity.this, R.layout.tch_chat_list_item, chatMemList);
        lv_tch_chat = findViewById(R.id.lv_tch_chat);
        lv_tch_chat.setAdapter(tchChatAdapter);


        /*
        어댑터에서  클릭 이벤트 연결해야됨.
        cardView = findViewById(R.id.chat_mem1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vo.getMemberId() != null){
                    vo.setRoomName1(vo.getMemberName());
                    Intent intent = new Intent(TchChatListActivity.this, Chat.class);
                    startActivity(intent);
                }else{
                    vo.setRoomName1("김회원");
                    Intent intent = new Intent(TchChatListActivity.this, Chat.class);
                    startActivity(intent);
                }
                //Toast.makeText(TchChatListActivity.this, "김회원 회원 선택", Toast.LENGTH_SHORT).show();
            }
        });

         */

    }
}
