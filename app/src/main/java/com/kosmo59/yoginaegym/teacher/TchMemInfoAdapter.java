package com.kosmo59.yoginaegym.teacher;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;

import java.util.List;
import java.util.Map;


public class TchMemInfoAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> infoList = null;
    int resourceId;

    AppVO vo = null;

    public TchMemInfoAdapter(@NonNull Context context, int resource, @NonNull List infoList) {
        super(context, resource, infoList);
        this.context = context;
        this.resourceId = resource;
        this.infoList = infoList;
    }

    @Override
    public int getCount() {
        return infoList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return infoList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);

        Log.i("TchMemInfoAdapter", "info list size : "+infoList.size()+", "+infoList);

        TextView tch_mem_info_name = convertView.findViewById(R.id.tch_mem_info_name); //회원이름
        TextView tch_mem_info_cdates = convertView.findViewById(R.id.tch_mem_info_cdates); //남은 횟수
        ProgressBar tch_mem_info_pb_cont = convertView.findViewById(R.id.tch_mem_info_pb_cont);

        TextView tch_mem_info_mem_cnt = convertView.findViewById(R.id.tch_mem_info_mem_cnt);  //남은 일수
        ProgressBar tch_mem_info_pb_cont_day = convertView.findViewById(R.id.tch_mem_info_pb_cont_day);

        TextView tch_mem_info_gender = convertView.findViewById(R.id.tch_mem_info_gender);
        TextView tch_mem_info_tel = convertView.findViewById(R.id.tch_mem_info_tel);
        TextView tch_mem_info_birth = convertView.findViewById(R.id.tch_mem_info_birth);
        TextView tch_mem_info_sdates = convertView.findViewById(R.id.tch_mem_info_sdates); //등록일
        TextView tch_mem_info_edates = convertView.findViewById(R.id.tch_mem_info_edates); //종료일

        tch_mem_info_name.setText(infoList.get(position).get("MEM_NAME").toString());

        //String strMem_no = hidden_mem_no.getText().toString();
        //String subMem_no = strMem_no.substring(0, strMem_no.length()-2);

        //남은 횟수
        String strImsi =  infoList.get(position).get("MEM_CNT").toString();
        String sub_MEM_CNT = strImsi.substring(0, strImsi.length()-2);
        strImsi = infoList.get(position).get("CLS_CNT").toString();
        String sub_CLS_CNT = strImsi.substring(0, strImsi.length()-2);
        tch_mem_info_cdates.setText(sub_MEM_CNT+" / "+sub_CLS_CNT);
        tch_mem_info_pb_cont.setProgress(Integer.parseInt(sub_MEM_CNT));
        tch_mem_info_pb_cont.setMax(Integer.parseInt(sub_CLS_CNT));

        //남은 일수
        strImsi = infoList.get(position).get("CNT").toString();
        String sub_CNT = strImsi.substring(0, strImsi.length()-2);
        strImsi = infoList.get(position).get("CLSDATES").toString();
        String sub_CLSDATES = strImsi.substring(0, strImsi.length()-2);
        tch_mem_info_mem_cnt.setText(sub_CNT+" / "+sub_CLSDATES);
        tch_mem_info_pb_cont_day.setProgress(Integer.parseInt(sub_CNT));
        tch_mem_info_pb_cont_day.setMax(Integer.parseInt(sub_CLSDATES));

        tch_mem_info_gender.setText(infoList.get(position).get("MEM_GENDER").toString());
        tch_mem_info_tel.setText(infoList.get(position).get("MEM_TEL").toString());
        tch_mem_info_birth.setText(infoList.get(position).get("MEM_BIRTH").toString());
        tch_mem_info_sdates.setText(infoList.get(position).get("SDATES").toString());
        tch_mem_info_edates.setText(infoList.get(position).get("EDATES").toString());

        return convertView;
    }
}
