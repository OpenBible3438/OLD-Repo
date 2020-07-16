package com.kosmo59.yoginaegym.common;

import com.kosmo59.yoginaegym.R;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

class MessageData {
    public String NAME; //발신자
    public String MSG;  //메시지
    public String TIME; //전송시간
    public String ID; //발신자 ID
}

public class ChatAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    ArrayList<MessageData> datas = new ArrayList<>();
    String user;

    public ChatAdapter(Context context, ArrayList<MessageData> ms, String user_name){
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datas = ms;
        this.user = user_name;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_chat,parent, false);
        }
        final MessageData data = datas.get(position);
        LinearLayout linearLayout = convertView.findViewById(R.id.layout_chat);
        TextView txt_receiver = convertView.findViewById(R.id.txt_receiver);
        TextView txt_msg = convertView.findViewById(R.id.txt_msg);
        TextView txt_time = convertView.findViewById(R.id.txt_time);
        ImageView imageView = convertView.findViewById(R.id.img_user);
        txt_receiver.setText(data.NAME);
        txt_msg.setText(data.MSG);
        txt_time.setText(data.TIME);

        if(!data.NAME.equals(user)){
            imageView.setVisibility(View.VISIBLE);
            linearLayout.setGravity(Gravity.LEFT);
        }
        if(data.NAME.equals(user)){
            imageView.setVisibility(View.GONE);
            linearLayout.setGravity(Gravity.RIGHT);
        }

        return convertView;
    }
}
