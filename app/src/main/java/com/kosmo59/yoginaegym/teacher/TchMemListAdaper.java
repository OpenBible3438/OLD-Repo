package com.kosmo59.yoginaegym.teacher;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;

import java.util.List;
import java.util.Map;

public class TchMemListAdaper extends ArrayAdapter {


    public static final String TAG = "TchMemListAdaper";
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    List<Map<String, Object>> mList = null;
    int resourceId;

    public TchMemListAdaper(Context context, int resource, List<Map<String, Object>> clsList) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        /*final View view = mLayoutInflater.inflate(R.layout.tchclasslistview_item, null);*/
        Log.i(TAG, "■■■■■■■■ position : " + position);

        CardView tch_class = (CardView) convertView.findViewById(R.id.tch_class);
        TextView cls_name = (TextView) convertView.findViewById(R.id.cls_name);
        TextView cls_stime = (TextView) convertView.findViewById(R.id.cls_stime);
        TextView cls_etime = (TextView) convertView.findViewById(R.id.cls_etime);
        TextView cls_day = (TextView) convertView.findViewById(R.id.cls_day);
        TextView cls_cnt = (TextView) convertView.findViewById(R.id.cls_cnt);


        cls_name.setText(mList.get(position).get("MEM_NAME").toString());
        cls_stime.setText(mList.get(position).get("CLS_S_DATE").toString());
        cls_etime.setText(mList.get(position).get("CLS_E_DATE").toString());
        cls_day.setText(mList.get(position).get("CLS_DAY").toString());
        cls_cnt.setText(""+Integer.valueOf((int)Math.round((double)mList.get(position).get("MEM_NUM"))));
        mList.get(position).get("MEM_NUM");
        final View finalConvertView = convertView;
        tch_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                final Dialog dlg = new Dialog(finalConvertView.getContext());

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_tch_mem_list);

                // 커스텀 다이얼로그를 노출한다.
                dlg.show();
            }
        });
        return convertView;
    }

}
