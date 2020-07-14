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



}
