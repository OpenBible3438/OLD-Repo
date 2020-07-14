package com.kosmo59.yoginaegym.teacher;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.kosmo59.yoginaegym.R;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Map;

public class TchMemListAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> mList = null;
    int resourceId;

    public TchMemListAdapter(@NonNull Context context, int resource, @NonNull List mList) {
        super(context, resource, mList);
        this.context = context;
        this.mList = mList;
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
        Log.i("TchMemListAdapter", "호출");

        TextView tch_memList_name = convertView.findViewById(R.id.tch_memList_name);
        TextView tch_memList_birth = convertView.findViewById(R.id.tch_memList_birth);
        TextView mem_memList_tel = convertView.findViewById(R.id.mem_memList_tel);

        tch_memList_name.setText(mList.get(position).get("MEM_NAME").toString());
        tch_memList_birth.setText(mList.get(position).get("MEM_BIRTH").toString());
        mem_memList_tel.setText(mList.get(position).get("MEM_TEL").toString());

        return convertView;
    }
}
