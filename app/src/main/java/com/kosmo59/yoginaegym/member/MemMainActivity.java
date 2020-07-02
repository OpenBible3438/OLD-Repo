package com.kosmo59.yoginaegym.member;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.gym.GymSearchActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemMainActivity extends AppCompatActivity {

    private Button btn_memGymSearch, btn_memInfo, btn_memTimeTable, btn_memClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_main);

        btn_memGymSearch = findViewById(R.id.btn_memGymSearch);
        btn_memInfo = findViewById(R.id.btn_memInfo);
        btn_memTimeTable = findViewById(R.id.btn_memTimeTable);
        btn_memClass = findViewById(R.id.btn_memClass);

        btn_memGymSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemMainActivity.this, GymSearchActivity.class);
                startActivity(intent);
            }
        });
        btn_memInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //내 정보 눌렀을 때
                Intent intent = new Intent(MemMainActivity.this, MemProfileActivity.class);
                startActivity(intent);
            }
        });
        btn_memTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //시간표 눌렀을 때
            }
        });
        btn_memClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //내 수업 눌렀을 때
            }
        });
    }
}
