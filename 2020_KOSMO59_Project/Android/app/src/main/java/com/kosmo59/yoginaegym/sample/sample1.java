package com.kosmo59.yoginaegym.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.kosmo59.yoginaegym.R;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class sample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample1);
/*
        //툴바 & 햄버거
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView hamburger = findViewById(R.id.iv_hamburger);
        final DrawerLayout layout_sample = findViewById(R.id.layout_sample);
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_sample.openDrawer(GravityCompat.START);
            }
        });
 */
    }
}
