package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kosmo59.yoginaegym.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class MyReviewAdapter extends ArrayAdapter {
    Context mContext = null;
    List<Map<String, Object>> revList = null;
    int resourceId;
    String result = null;

    public MyReviewAdapter(Context context, int resource, List<Map<String, Object>> revList, String result) {
        super(context, resource, revList);
        this.mContext = context;
        this.revList = revList;
        this.resourceId = resource;
        this.result = result;
    }

    @Override
    public int getCount() {
        return revList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return revList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);

        // 작성자 tv_myReview_memNick
        // 날짜 tv_myReview_date
        // 내용 tv_myReview_cont
        // 별저 rb_myReview
        TextView tv_myReview_memNick = convertView.findViewById(R.id.tv_myReview_memNick);
        TextView tv_myReview_date = convertView.findViewById(R.id.tv_myReview_date);
        TextView tv_myReview_cont = convertView.findViewById(R.id.tv_myReview_cont);
        RatingBar rb_myReview = convertView.findViewById(R.id.rb_myReview);
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(result);
            jsonObject = jsonArray.getJSONObject(position);
            tv_myReview_memNick.setText(jsonObject.getString("MEM_NICKNAME"));
            tv_myReview_date.setText(jsonObject.getString("REV_DATE"));
            tv_myReview_cont.setText(jsonObject.getString("REV_CONT"));
            rb_myReview.setMax(100);
            rb_myReview.setProgress(jsonObject.getInt("REV_STAR"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertView;
    }

}
