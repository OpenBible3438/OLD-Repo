package com.kosmo59.yoginaegym.teacher;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.member.MemLogDetailDialog;
import com.kosmo59.yoginaegym.member.MemLogFragment;

import java.util.List;
import java.util.Map;

public class TchLogAdapter extends ArrayAdapter {

    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;
    TchLogFragment tchLogFragment;
    private CardView dailyRecord_1;

    public TchLogAdapter(Context context, int resource, List<Map<String, Object>> clsList, TchLogFragment tchLogFragment) {
        super(context, resource, clsList);
        this.mContext = context;
        this.mList = clsList;
        this.resourceId = resource;
        this.tchLogFragment = tchLogFragment;
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
        TextView tch_log_cont = (TextView) convertView.findViewById(R.id.tch_log_cont);
        TextView tch_log_title = (TextView) convertView.findViewById(R.id.tch_log_title);
        TextView tch_log_exDate = (TextView) convertView.findViewById(R.id.tch_log_exDate);
        TextView tch_log_regDate = (TextView) convertView.findViewById(R.id.tch_log_regDate);
        tch_log_cont.setText(mList.get(position).get("log_cont").toString());
        tch_log_title.setText(mList.get(position).get("log_title").toString());
        tch_log_exDate.setText(mList.get(position).get("ex_date").toString());
        tch_log_regDate.setText(mList.get(position).get("reg_date").toString());
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        dailyRecord_1 = convertView.findViewById(R.id.dailyRecord_1);
        Log.i("TchLogAdapter", "dailyRecord_1 : " + dailyRecord_1);
        Log.i("TchLogAdapter", "R.id.dailyRecord_1 : " + R.id.dailyRecord_1);
        dailyRecord_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TchLogAdapter", "dailyRecord onClick 호출");
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                TchLogDetailDialog tchLogDetailDialog = new TchLogDetailDialog(v.getContext()
                        , Integer.parseInt(mList.get(position).get("_id").toString()), tchLogFragment);

                // 커스텀 다이얼로그를 호출한다.
                tchLogDetailDialog.openTchLogDetailDialog();
            }
        });

        return convertView;
    }

}
