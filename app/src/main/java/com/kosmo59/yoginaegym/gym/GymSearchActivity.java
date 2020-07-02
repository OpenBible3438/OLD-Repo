package com.kosmo59.yoginaegym.gym;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GymSearchActivity extends AppCompatActivity {

    private Button btn_gymProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_search);

        btn_gymProfile = findViewById(R.id.btn_moveGymProfile);
        btn_gymProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GymSearchActivity.this, GymProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
