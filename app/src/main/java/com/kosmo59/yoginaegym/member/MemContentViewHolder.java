package com.kosmo59.yoginaegym.member;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.kosmo59.yoginaegym.R;

public class MemContentViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_contLike;
    public ImageView ib_emptyHeart;
    public TextView tv_mem_conts_title;
    public TextView tv_mem_conts_text;
    public TextView tv_like_num;
    public TextView tv_mem_conts_date;
    ImageView iv_mem_conts_img;
    //좋아요 수
    public int like=0;
    //1이면 눌려있을 때, 0이면 안 눌려있을 때
    public int check_num = 0;


    MemContentViewHolder(View itemView){
        super(itemView);
        ib_emptyHeart = itemView.findViewById(R.id.ib_emptyHeart1);
        Log.i("MemContentViewHolder", "ib_emptyHeart : " + ib_emptyHeart);
        ib_emptyHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_num == 0){
                    //눌려있지 않은 상태에서 눌렸으면 1로 바꾸어주기 => 눌린상태
                    check_num = 1;
                    ib_emptyHeart.setSelected(true); //이미지버튼이 선택된 상태니까 true
                    ib_emptyHeart.setImageResource(R.drawable.cont_heart); //눌렸으니까 색칠되어있는 하트 이미지로 변경
                    Log.i("MemContentAdapter", "R.drawable.cont_heart : " +  R.drawable.cont_heart);
                    Log.i("MemContentAdapter", "ib_emptyHeart : " +  ib_emptyHeart);
                    like+=1;
                    tv_like_num.setText(Integer.toString(like));
                    //tv_contLike.setText(like+"명이 좋아합니다");
                }
                else{  //이미지 버튼이 눌려있을 때 (check_num == 1)인 상태
                    check_num = 0; //눌려있을 때 다시 누르면 안 눌린 상태로 돌려야되니까 check_num=0으로
                    ib_emptyHeart.setSelected(false); //이미지 버튼이 선택 안 되어있으니까 상태 false
                    ib_emptyHeart.setImageResource(R.drawable.cont_heart_empty); //다시 눌리지 않은 상태니까 이미지를 빈 하트 이미지로 변경
                    like-=1;
                    tv_like_num.setText(Integer.toString(like));
                    //tv_contLike.setText(like+"명이 좋아합니다");
                }
            }
        });
    }

}
