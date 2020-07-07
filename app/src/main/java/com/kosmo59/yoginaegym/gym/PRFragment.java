package com.kosmo59.yoginaegym.gym;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.kosmo59.yoginaegym.R;

public class PRFragment extends Fragment {

    //1이면 눌려있을 때, 0이면 안 눌려있을 때
    private int check_num = 0;
    //이미지 버튼
    private ImageButton ib_prHeart;

    public PRFragment() {
        // fragment에서 findViewById를 사용하고 싶으면 getView를 사용해야 한다.
        ib_prHeart = getView().findViewById(R.id.ib_prHeart);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_p_r, container, false);

    }
    public void cont_clickHeart(View view) {
        //0이면 눌려있지 않을 때 => 빈 하트
        if(check_num == 0){
            //눌려있지 않은 상태에서 눌렸으면 1로 바꾸어주기 => 눌린상태
            check_num = 1;
            ib_prHeart.setSelected(true); //이미지버튼이 선택된 상태니까 true
            ib_prHeart.setImageResource(R.drawable.cont_heart); //눌렸으니까 색칠되어있는 하트 이미지로 변경
        }
        else{  //이미지 버튼이 눌려있을 때 (check_num == 1)인 상태
            check_num = 0; //눌려있을 때 다시 누르면 안 눌린 상태로 돌려야되니까 check_num=0으로
            ib_prHeart.setSelected(false); //이미지 버튼이 선택 안 되어있으니까 상태 false
            ib_prHeart.setImageResource(R.drawable.cont_heart_empty); //다시 눌리지 않은 상태니까 이미지를 빈 하트 이미지로 변경
        }
    }
}




