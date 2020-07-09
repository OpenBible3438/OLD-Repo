package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.Chat;
import com.kosmo59.yoginaegym.member.MemChatListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TchChatListActivity extends AppCompatActivity {

    private CardView cardView;
    static AppVO vo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_chat_list);

        vo = (AppVO)getApplicationContext();
        cardView = findViewById(R.id.chat_mem1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vo.setRoomName1("김회원");
                Toast.makeText(TchChatListActivity.this, "김회원 회원 선택", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TchChatListActivity.this, Chat.class);
                startActivity(intent);
            }
        });

    }
}
