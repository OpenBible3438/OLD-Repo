package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.kosmo59.yoginaegym.R;

import java.util.List;
import java.util.Map;

public class GymNoticeAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> noticeList = null;
    int resourceId;
    final String NOTICE_LOG = "GymNoticeAdapter";

    public GymNoticeAdapter(@NonNull Context context, int resource, @NonNull List noticeList) {
        super(context, resource, noticeList);
        this.context = context;
        this.resourceId = resource;
        this.noticeList = noticeList;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return noticeList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i(NOTICE_LOG, "■■■■■■■■ position : " + position);
        Log.i(NOTICE_LOG, "noticeList.get(position) : " + noticeList.get(position));
        //id 연결하기
        TextView tv_gym_not_title = convertView.findViewById(R.id.tv_gym_not_title);
        TextView tv_gym_not_date = convertView.findViewById(R.id.tv_gym_not_date);
        TextView tv_gym_not_time = convertView.findViewById(R.id.tv_gym_not_time);
        TextView tv_gym_not_conts = convertView.findViewById(R.id.tv_gym_not_conts);

        tv_gym_not_title.setText(noticeList.get(position).get("NOT_TITLE").toString());
        tv_gym_not_date.setText(noticeList.get(position).get("NOT_DATE").toString());
        tv_gym_not_time.setText(noticeList.get(position).get("NOT_TIME").toString());
        tv_gym_not_conts.setText(noticeList.get(position).get("NOT_CONT").toString());

        return convertView;
    }
}
