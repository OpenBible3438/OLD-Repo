package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.kosmo59.yoginaegym.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

public class MemContentAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> contList = null;
    int resourceId;
    final String NOTICE_LOG = "MemContentAdapter";

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
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i(NOTICE_LOG, "■■■■■■■■ position : " + position);
        Log.i(NOTICE_LOG, "contList.get(position) : " + contList.get(position));
        //id 연결하기
        TextView tv_mem_conts_title = convertView.findViewById(R.id.tv_mem_conts_title);
        ImageView iv_mem_conts_cont = convertView.findViewById(R.id.iv_mem_conts_img);
        TextView tv_mem_conts_text = convertView.findViewById(R.id.tv_mem_conts_text);
        TextView tv_like_num = convertView.findViewById(R.id.tv_mem_conts_like_num);
        TextView tv_mem_conts_date = convertView.findViewById(R.id.tv_mem_conts_date);

        /*tv_gym_not_title.setText(contList.get(position).get("NOT_TITLE").toString());
        tv_gym_not_date.setText(contList.get(position).get("NOT_DATE").toString());
        tv_gym_not_time.setText(contList.get(position).get("NOT_TIME").toString());
        tv_gym_not_conts.setText(contList.get(position).get("NOT_CONT").toString());*/

        return convertView;
    }
}
