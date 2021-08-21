package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatImg;

import java.util.List;
import java.util.Map;

public class MemContentAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> contList = null;
    int resourceId;
    final String NOTICE_LOG = "MemContentAdapter";
    //1이면 눌려있을 때, 0이면 안 눌려있을 때
    MemContentViewHolder viewHolder;

    public MemContentAdapter(@NonNull Context context, int resource, @NonNull List contList) {
        super(context, resource, contList);
        this.context = context;
        this.resourceId = resource;
        this.contList = contList;
    }

    @Override
    public int getCount() {
        return contList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return contList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        Log.i(NOTICE_LOG, "■■■■■■■■ position : " + position);
        Log.i(NOTICE_LOG, "contList.get(position) : " + contList.get(position));

        if(convertView == null){
            //id 연결하기
            convertView = inflater.inflate(R.layout.mem_content_item, parent, false);
            viewHolder = new MemContentViewHolder(convertView);
            viewHolder.tv_mem_conts_title = convertView.findViewById(R.id.tv_mem_conts_title);
            viewHolder.tv_mem_conts_text = convertView.findViewById(R.id.tv_mem_conts_text);
            viewHolder.tv_like_num = convertView.findViewById(R.id.tv_mem_conts_like_num);
            viewHolder.tv_mem_conts_date = convertView.findViewById(R.id.tv_mem_conts_date);
            viewHolder.ib_emptyHeart = convertView.findViewById(R.id.ib_emptyHeart1);
            viewHolder.iv_mem_conts_img = convertView.findViewById(R.id.iv_mem_conts_img);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (MemContentViewHolder) convertView.getTag();
        }

        viewHolder.tv_mem_conts_title.setText(contList.get(position).get("WHO").toString());
        viewHolder.tv_mem_conts_text.setText(contList.get(position).get("CONT_CONT").toString());
        viewHolder.tv_like_num.setText(contList.get(position).get("CONT_LIKE").toString());
        viewHolder.tv_mem_conts_date.setText(contList.get(position).get("CONT_DATE").toString());
        viewHolder.like = Integer.parseInt(viewHolder.tv_like_num.getText().toString());
        try {
            String file_seq = contList.get(position).get("FILE_SEQ").toString();
            TomcatImg tomcatImg = new TomcatImg();
            String bitImg = tomcatImg.execute(file_seq).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            viewHolder.iv_mem_conts_img.setImageBitmap(bitmap);
        } catch (Exception e) {
            Log.i("MemContentAdapter", "비트맵 이미지 처리 실패");
            e.printStackTrace();
        }
        return convertView;
    }


}
