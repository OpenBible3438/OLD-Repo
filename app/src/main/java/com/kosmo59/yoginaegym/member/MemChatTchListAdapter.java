package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.Chat;

import java.util.List;
import java.util.Map;

public class MemChatTchListAdapter extends ArrayAdapter {
    AppVO vo = null;
    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;
    private CardView cardView;

    public MemChatTchListAdapter(@NonNull Context context, int resource, @NonNull List clsList) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i("테스트", "■■■■■■■■ position : " + position);
        Log.i("테스트", "mList.get(position) : " + mList.get(position));

        final TextView tch_name = convertView.findViewById(R.id.tch_name);
        final TextView tch_gender = convertView.findViewById(R.id.tch_gender);
        final TextView tch_tel = convertView.findViewById(R.id.tch_tel);
        cardView = convertView.findViewById(R.id.chat_tch);
        tch_name.setText(mList.get(position).get("TCH_NAME").toString());
        tch_gender.setText(mList.get(position).get("TCH_GENDER").toString());
        tch_tel.setText(mList.get(position).get("TCH_TEL").toString());
        vo = (AppVO)mContext.getApplicationContext();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("테스트", "position : " + position);
                Log.i("테스트", "mList : " + mList.get(position));
                vo.setRoomName2(tch_name.getText().toString());
                Intent intent = new Intent(mContext, Chat.class);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }


}
