package com.kosmo59.yoginaegym.common;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ContentActivity extends AppCompatActivity {
    //1이면 눌려있을 때, 0이면 안 눌려있을 때
    private int check_num = 0;
    //이미지 버튼
    private ImageButton ib_emptyHeart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //이미지 버튼의 xml id 연결
        ib_emptyHeart = findViewById(R.id.ib_emptyHeart);

    }

    public void cont_clickHeart(View view) {
        //0이면 눌려있지 않을 때 => 빈 하트
        if(check_num == 0){
            //눌려있지 않은 상태에서 눌렸으면 1로 바꾸어주기 => 눌린상태
            check_num = 1;
            ib_emptyHeart.setSelected(true); //이미지버튼이 선택된 상태니까 true
            ib_emptyHeart.setImageResource(R.drawable.cont_heart); //눌렸으니까 색칠되어있는 하트 이미지로 변경
        }
        else{  //이미지 버튼이 눌려있을 때 (check_num == 1)인 상태
            check_num = 0; //눌려있을 때 다시 누르면 안 눌린 상태로 돌려야되니까 check_num=0으로
            ib_emptyHeart.setSelected(false); //이미지 버튼이 선택 안 되어있으니까 상태 false
            ib_emptyHeart.setImageResource(R.drawable.cont_heart_empty); //다시 눌리지 않은 상태니까 이미지를 빈 하트 이미지로 변경
        }
    }
}
