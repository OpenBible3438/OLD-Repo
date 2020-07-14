package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.kosmo59.yoginaegym.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

public class ClassAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> classList = null;
    private ImageButton btn_class_detail;
    int resourceId;
    final String GYM_CLASS_LOG = "GymClassAdapter";
    public ClassAdapter(@NonNull Context context, int resource, @NonNull List classList) {
        super(context, resource, classList);
        this.context = context;
        this.resourceId = resource;
        this.classList = classList;
    }
    @Override
    public int getCount() {
        return classList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return classList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i(GYM_CLASS_LOG, "■■■■■■■■ position : " + position);
        Log.i(GYM_CLASS_LOG, "classList.get(position) : " + classList.get(position));

        //id 연결하기
        TextView tv_gym_class_title = convertView.findViewById(R.id.tv_gym_class_title);
        TextView tv_gym_class_startDate = convertView.findViewById(R.id.tv_gym_class_startDate);
        TextView tv_gym_class_endDate = convertView.findViewById(R.id.tv_gym_class_endDate);
        TextView tv_gym_class_time = convertView.findViewById(R.id.tv_gym_class_time);
        TextView tv_gym_class_price = convertView.findViewById(R.id.tv_gym_class_price);
        Log.i("테스트테", "classList.get(position) : " + classList.get(position));
        tv_gym_class_title.setText(classList.get(position).get("CLS_NAME").toString());
        tv_gym_class_startDate.setText(classList.get(position).get("CLS_S_DATE").toString());
        tv_gym_class_endDate.setText(classList.get(position).get("CLS_E_DATE").toString());
        String stime = classList.get(position).get("CLS_STIME").toString();
        String etime = classList.get(position).get("CLS_ETIME").toString();
        tv_gym_class_time.setText(stime+" - "+etime);
        tv_gym_class_price.setText(classList.get(position).get("CLS_PRICE").toString());

        //자세히보기 이미지 버튼 리스너
        btn_class_detail = convertView.findViewById(R.id.btn_class_detail);
        btn_class_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                ClassDetailDialog classDetailDialog = new ClassDetailDialog(context);
                // 커스텀 다이얼로그를 호출한다.
                classDetailDialog.openClassDetailDialog();
            }
        });

        return convertView;
    }
}
