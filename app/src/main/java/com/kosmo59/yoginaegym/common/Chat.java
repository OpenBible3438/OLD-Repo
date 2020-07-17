package com.kosmo59.yoginaegym.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.teacher.TchChatAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Chat extends AppCompatActivity {

    private DatabaseReference databaseReference = null;
    private ListView lv_chatList;
    private String roomName = null;

    //변경된 Adapter
    ChatAdapter chatAdapter;
    private ArrayAdapter<MessageData> arrayAdapter;
    private ArrayList<MessageData> chatList = new ArrayList<>();

    //list view에 출력
    private String chat_msg=null, chat_user=null, chat_number = null, chat_time=null;

    //데이터에 저장
    private Button btn_msgSend;
    private EditText et_msgSend;
    private String send_name = null, send_id = null;

    //시간
    private SimpleDateFormat simpleDateFormat = null;

    private AppVO vo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        lv_chatList = findViewById(R.id.lv_chatList);
        btn_msgSend = findViewById(R.id.btn_msgSend);
        et_msgSend = findViewById(R.id.et_msgSend);
        vo = (AppVO)getApplicationContext();

        chatAdapter = new ChatAdapter(this, chatList, vo.getMsgSendName());
        lv_chatList.setAdapter(chatAdapter);

        //채팅방 이름 설정
        roomName = vo.getRoomName1()+vo.getRoomName2();

        //Firebase Database에 roomName으로 참조
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Chat").child(roomName).child(new SimpleDateFormat("YYYY-MM-dd").format(System.currentTimeMillis()));

        simpleDateFormat = new SimpleDateFormat("HH:mm");

        send_name = vo.getMsgSendName();
        send_id = vo.getMsgSendName();

        /*
        if(vo.getMemberId()!=null){
            //회원 번호가 null이 아니면 회원으로 로그인한 것
            send_name = vo.getMemberName();
            send_id = vo.getMemberId();
        }
        else if(vo.getTchId()!=null){
            //강사 번호가 null이 아니면 강사로 로그인한 것
            send_name = vo.getTchName();
            send_id = vo.getTchId();
        }

         */

        btn_msgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_msgSend.getText().toString().equals("")){
                    //아무것도 입력하지 않고 전송 눌렀을 때 데이터 전송하지 않음
                    return;
                }
                Map<String, Object> map = new HashMap<>();
                String key = databaseReference.push().getKey();
                databaseReference.updateChildren(map);

                DatabaseReference updateRef = databaseReference.child(key);
                Map<String, Object> objectMap = new HashMap<>();
                String time = simpleDateFormat.format(System.currentTimeMillis());

                objectMap.put("name", send_name);
                objectMap.put("text", et_msgSend.getText().toString());
                //objectMap.put("id", send_id);
                objectMap.put("time", time);
                updateRef.updateChildren(objectMap);

                et_msgSend.setText("");
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                chatConversation(snapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                chatConversation(snapshot);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void chatConversation(DataSnapshot dataSnapshot){
        Iterator i = dataSnapshot.getChildren().iterator();
        while (i.hasNext()){
            MessageData data = new MessageData();
            Log.i("테스트", "MessageData : " + data);
            Log.i("테스트", "i.next()).getValue() : " + ((DataSnapshot) i.next()).getValue());
            data.NAME = (String) ((DataSnapshot) i.next()).getValue();
            data.MSG = chat_msg = (String)((DataSnapshot) i.next()).getValue();
            data.TIME = (String) ((DataSnapshot) i.next()).getValue();
            chatList.add(data);
            /*chat_number = ((DataSnapshot)i.next()).getValue().toString(); //id임
            chat_user = ((DataSnapshot)i.next()).getValue().toString();//name
            chat_msg = ((DataSnapshot)i.next()).getValue().toString();
            chat_time = ((DataSnapshot)i.next()).getValue().toString();
            //불러온 것들 중 이름과 text를 ListView에 출력
            chatList.add("["+chat_user+"] : "+chat_msg);*/
        }
        chatAdapter.notifyDataSetChanged();
    }
}
