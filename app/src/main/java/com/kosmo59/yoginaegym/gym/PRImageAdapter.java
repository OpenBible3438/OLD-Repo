package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatImg;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* PRImageFragment에 연결되는 Adapter */
public class PRImageAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> prImageList = null;
    int resourceId;

    ArrayAdapter<Bitmap> arrayList;


    public PRImageAdapter(@NonNull Context context, int resource, List prImageList) {
        super(context, resource, prImageList);
        this.context = context;
        this.resourceId = resource;
        this.prImageList = prImageList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return prImageList.size();
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return prImageList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        반드시 구현해야되는 곳
        Adapter에 추가된 이미지를 표시함
        convertView가 null 일 때 새로운 이미지 객체를 생성해서 화면에 표시
         */
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i("PRImageAdapter", "호출 성공");
        Log.i("PRImageAdapter", "prImageList.size() : "+prImageList.size());

        ImageView imageView;
        imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,350));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(3,3,3,3 );

        try{
            TomcatImg tomcatImg = new TomcatImg();
            String imsi = prImageList.get(position).get("FILE_SEQ").toString().substring(0, prImageList.get(position).get("FILE_SEQ").toString().length()-2);
            String bitImg = tomcatImg.execute(imsi).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            imageView.setImageBitmap(bitmap);
        }catch (Exception e){
            Log.i("PRImageAdapter", "Exception : "+e.toString());
        }

        return imageView;
    }
}
