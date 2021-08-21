package com.kosmo59.yoginaegym.member;

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

public class PayListAdapter extends ArrayAdapter {

    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;

    public PayListAdapter(Context context, int resource, List<Map<String, Object>> clsList) {
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
        Log.i("테스트", "■■■■■■■■ position : " + position);
        Log.i("테스트", "mList.get(position) : " + mList.get(position));
        TextView p_gym_name = (TextView) convertView.findViewById(R.id.p_gym_name);
        TextView p_cls_name = (TextView) convertView.findViewById(R.id.p_cls_name);
        TextView p_tch_name = (TextView) convertView.findViewById(R.id.p_tch_name);
        TextView p_cls_price = (TextView) convertView.findViewById(R.id.p_cls_price);
        TextView p_pay_date = (TextView) convertView.findViewById(R.id.p_pay_date);

        p_gym_name.setText(mList.get(position).get("GYM_NAME").toString());
        p_cls_name.setText(mList.get(position).get("CLS_NAME").toString());
        p_tch_name.setText(mList.get(position).get("TCH_NAME").toString());
        p_cls_price.setText(""+Integer.valueOf((int)Math.round((double)mList.get(position).get("CLS_PRICE"))));
        p_pay_date.setText(mList.get(position).get("PAY_DATE").toString());
        return convertView;
    }


}
