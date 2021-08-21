package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.kosmo59.yoginaegym.R;

import java.util.List;
import java.util.Map;

public class GymReviewAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> rewiewList = null;
    int resourceId;
    final String GYM_REVIEW_LOG = "GymReviewAdapter";

    public GymReviewAdapter(@NonNull Context context, int resource, @NonNull List classList) {
        super(context, resource, classList);
        this.context = context;
        this.resourceId = resource;
        this.rewiewList = classList;
    }
    @Override
    public int getCount() {
        return rewiewList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return rewiewList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);

        Log.i(GYM_REVIEW_LOG, "■■■■■■■■ position : " + position);
        Log.i(GYM_REVIEW_LOG, "rewiewList.get(position) : " + rewiewList.get(position));

        //id 연결하기
        TextView tv_gym_review_memNick = convertView.findViewById(R.id.tv_gym_review_memNick);
        TextView tv_gym_review_cont = convertView.findViewById(R.id.tv_gym_review_cont);
        TextView tv_gym_review_date = convertView.findViewById(R.id.tv_gym_review_date);
        RatingBar rb_gym_review = convertView.findViewById(R.id.rb_gym_review);

        Log.i("테스트", "rewiewList.get(position) : " + rewiewList.get(position));

        tv_gym_review_memNick.setText(rewiewList.get(position).get("MEM_NICKNAME").toString());
        tv_gym_review_cont.setText(rewiewList.get(position).get("REV_CONT").toString());
        tv_gym_review_date.setText(rewiewList.get(position).get("REV_DATE").toString());

        String star = rewiewList.get(position).get("REV_STAR").toString();

        final String starResult = star.substring(0, star.length()-2);
        int starResultToInt = Integer.parseInt(starResult);

        Log.i("레이팅바", "레이팅바 : " + starResultToInt);
        rb_gym_review.setMax(100);
        rb_gym_review.setProgress(starResultToInt);
        //String etime = rewiewList.get(position).get("CLS_ETIME").toString();

        return convertView;
    }
}
