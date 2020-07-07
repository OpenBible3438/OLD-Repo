package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.kosmo59.yoginaegym.R;

/* PRImageFragment에 연결되는 Adapter */
public class PRImageAdapter extends BaseAdapter {
    Context context;

    //PR Images
    private Integer[] prImages = {
            R.drawable.PRSample1,
            R.drawable.PRSample2,
            R.drawable.PRSample3,
            R.drawable.PRSample4,
            R.drawable.PRSample5
    };

    //생성자
    public PRImageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        //이미지 몇개?
        return prImages.length;
    }

    @Override
    public Object getItem(int position) {
        //지정된 인덱스에 있는 실제 객체를 반환
        return null;
    }

    @Override
    public long getItemId(int position) {
        //항목의 행 ID 반환
        return 0;
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
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        else{
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(prImages[position]);

        return null;
    }
}
