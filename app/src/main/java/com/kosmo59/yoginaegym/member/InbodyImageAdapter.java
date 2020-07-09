package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.kosmo59.yoginaegym.R;

public class InbodyImageAdapter extends BaseAdapter {
    Context context;
    //PR Images 배열
    public Integer[] inbodyImages = {
            R.drawable.inbody_ex1,
            R.drawable.inbody_ex2,
            R.drawable.inbody_ex3,
            R.drawable.inbody_ex4,
            R.drawable.inbody_ex5,
            R.drawable.inbody_ex6,
            R.drawable.inbody_ex7,
            R.drawable.inbody_ex8,
    };

    public InbodyImageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        //이미지 총 몇개야
        return inbodyImages.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        반드시 구현해야되는 곳
        Adapter에 추가된 이미지를 표시함
        convertView가 null 일 때 새로운 이미지 객체를 생성해서 화면에 표시
         */
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1,1,1,1 );
        }
        else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(inbodyImages[position]);
        return imageView;
    }
}
