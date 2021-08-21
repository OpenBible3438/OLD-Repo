package com.kosmo59.yoginaegym;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.PagerAdapter;

public class MainImageAdapter extends PagerAdapter {
    private int[] images = {R.drawable.img_main1,R.drawable.img_main2,R.drawable.img_main3_c,R.drawable.img_main4};
    private LayoutInflater inflater;
    private Context context;

    public MainImageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount(){
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == ((LinearLayout) object);
    }

    public Object instantiateItem(ViewGroup container, int position){
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.main_image_slider, container, false);
        ImageView imageView = (ImageView)v.findViewById(R.id.iv_mainSlider);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }

}
