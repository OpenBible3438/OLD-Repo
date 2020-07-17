package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;

import java.util.List;
import java.util.Map;

public class MemLogAdapter extends ArrayAdapter {

    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;

    private CardView dailyRecord_1;

    public MemLogAdapter(Context context, int resource, List<Map<String, Object>> clsList) {
        super(context, resource, clsList);
        this.mContext = context;
        this.mList = clsList;
        this.resourceId = resource;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return mList.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i("테스트", "mList.get(position) : " + mList.get(position));
        TextView mem_log_cont = (TextView) convertView.findViewById(R.id.mem_log_cont);
        TextView mem_log_title = (TextView) convertView.findViewById(R.id.mem_log_title);
        TextView mem_log_exDate = (TextView) convertView.findViewById(R.id.mem_log_exDate);
        TextView mem_log_regDate = (TextView) convertView.findViewById(R.id.mem_log_regDate);
        mem_log_cont.setText(mList.get(position).get("log_cont").toString());
        mem_log_title.setText(mList.get(position).get("log_title").toString());
        mem_log_exDate.setText(mList.get(position).get("ex_date").toString());
        mem_log_regDate.setText(mList.get(position).get("reg_date").toString());
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        dailyRecord_1 = convertView.findViewById(R.id.dailyRecord_1);
        Log.i("테스트", "dailyRecord_1 : " + dailyRecord_1);
        Log.i("테스트", "R.id.dailyRecord_1 : " + R.id.dailyRecord_1);
        dailyRecord_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("테스트", "dailyRecord onClick 호출");
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                MemLogDetailDialog memLogDetailDialog = new MemLogDetailDialog(v.getContext(), Integer.parseInt(mList.get(position).get("_id").toString()));

                // 커스텀 다이얼로그를 호출한다.
                memLogDetailDialog.openMemLogDetailDialog();
            }
        });

        return convertView;
    }

}
