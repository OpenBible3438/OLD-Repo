package com.kosmo59.yoginaegym.common;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ContentActivity extends AppCompatActivity {
    private int check_num = 0;
    private Drawable heart, heart_empty;
    private ImageButton ib_emptyHeart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        ib_emptyHeart = findViewById(R.id.ib_emptyHeart);

    }

    public void cont_clickHeart(View view) {
        if(check_num == 0){
            check_num = 1;
            ib_emptyHeart.setSelected(true);
            ib_emptyHeart.setImageResource(R.drawable.cont_heart);
        }
        else{
            check_num = 0;
            ib_emptyHeart.setSelected(false);
            ib_emptyHeart.setImageResource(R.drawable.cont_heart_empty);
        }
    }
}
