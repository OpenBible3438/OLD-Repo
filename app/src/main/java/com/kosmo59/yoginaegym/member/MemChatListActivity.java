package com.kosmo59.yoginaegym.member;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/* 회원이 채팅할 강사 리스트 출력 */
public class MemChatListActivity extends AppCompatActivity {

    private CardView cardView;
    static AppVO vo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_chat_list);

        vo = (AppVO)getApplicationContext();

        cardView = findViewById(R.id.chat_tch1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vo.setRoomName2("나강사");
                Toast.makeText(MemChatListActivity.this, "나강사 강사 선택", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MemChatListActivity.this, Chat.class);
                startActivity(intent);
            }
        });


    }

}
