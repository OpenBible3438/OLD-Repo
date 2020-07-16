package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class TchMyProfileActivity extends AppCompatActivity {
    private ImageButton icon_close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_my_profile);

        icon_close = findViewById(R.id.icon_close);
        icon_close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"activity_tch_main으로 이동해주세요.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
