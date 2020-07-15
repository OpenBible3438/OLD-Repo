package com.kosmo59.yoginaegym.member;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kosmo59.yoginaegym.R;

import java.util.List;
import java.util.Map;

public class MyClassAdapter extends ArrayAdapter {

    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;

    Button btn_memMyClass;
    private ImageButton icon_close;

    public MyClassAdapter(Context context, int resource, List<Map<String, Object>> clsList) {
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

        TextView cls_name = convertView.findViewById(R.id.cls_name);
        TextView cls_s_time = convertView.findViewById(R.id.cls_s_time);
        TextView cls_e_time = convertView.findViewById(R.id.cls_e_time);
        TextView cls_day = convertView.findViewById(R.id.cls_day);
        Log.i("테스트", "mList.get(position) : " + mList.get(position));
        cls_name.setText(mList.get(position).get("CLS_NAME").toString());
        cls_s_time.setText(mList.get(position).get("CLS_STIME").toString());
        cls_e_time.setText(mList.get(position).get("CLS_ETIME").toString());
        cls_day.setText(mList.get(position).get("CLS_DAY").toString());

        //자세히 보기 버튼
        btn_memMyClass = convertView.findViewById(R.id.btn_memMyClass);
        btn_memMyClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                final Dialog dlg = new Dialog(mContext);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_mem_my_class_detail);

                // 커스텀 다이얼로그를 노출한다.
                dlg.show();

                icon_close = dlg.findViewById(R.id.icon_close);
                icon_close.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        dlg.hide();
                    }
                });
            }
        });

        return convertView;
    }

}
