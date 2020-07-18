package com.kosmo59.yoginaegym.member;

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
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatImg;

import java.util.List;
import java.util.Map;

public class InbodyImageAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> inbodyList = null;
    int resourceId;

    ArrayAdapter<Bitmap> arrayList;

    public InbodyImageAdapter(@NonNull Context context, int resource, List inbodyList){
        super(context, resource, inbodyList);
        this.context = context;
        this.resourceId = resource;
        this.inbodyList = inbodyList;
    }

    @Override
    public int getCount() {
        return inbodyList.size();
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return inbodyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i("PRImageAdapter", "호출 성공");
        Log.i("PRImageAdapter", "prImageList.size() : "+inbodyList.size());

        ImageView imageView;
        imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,350));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(3,3,3,3 );

        try{
            TomcatImg tomcatImg = new TomcatImg();
            String imsi = inbodyList.get(position).get("FILE_SEQ").toString().substring(0, inbodyList.get(position).get("FILE_SEQ").toString().length()-2);
            String bitImg = tomcatImg.execute(imsi).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            imageView.setImageBitmap(bitmap);
        }catch (Exception e){
            Log.i("PRImageAdapter", "Exception : "+e.toString());
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, position+"번째 인바디 사진 클릭", Toast.LENGTH_SHORT).show();
                
            }
        });

        return imageView;
    }
}
