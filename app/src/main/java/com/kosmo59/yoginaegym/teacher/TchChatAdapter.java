package com.kosmo59.yoginaegym.teacher;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.Chat;
import com.kosmo59.yoginaegym.common.TomcatImg;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class TchChatAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> chatMemList = null;
    int resourceId;
    final String TCH_CHAT_LOG = "TchChatAdapter";
    public String mem_name=null;
    private AppVO vo = null;

    public TchChatAdapter(@NonNull Context context, int resource, @NonNull List chatMemList) {
        super(context, resource, chatMemList);
        this.context = context;
        this.resourceId = resource;
        this.chatMemList = chatMemList;
    }

    @Override
    public int getCount() {
        return chatMemList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return chatMemList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i(TCH_CHAT_LOG, "■■■■■■■■ position : " + position);
        Log.i(TCH_CHAT_LOG, "noticeList.get(position) : " + chatMemList.get(position));

        //id 연결하기
        final TextView tv_tch_chat_memName = convertView.findViewById(R.id.tv_tch_chat_memName);
        final TextView tv_tch_chat_gymName = convertView.findViewById(R.id.tv_tch_chat_gymName);
        final TextView tv_tch_chat_clsName = convertView.findViewById(R.id.tv_tch_chat_clsName);
        final CardView cv_chat_list = convertView.findViewById(R.id.cv_chat_list);
        //사진 추가 - 성경
        final CircleImageView iv_tch_chat_mem_img = convertView.findViewById(R.id.iv_tch_chat_mem_img);

        tv_tch_chat_memName.setText(chatMemList.get(position).get("MEM_NAME").toString());
        tv_tch_chat_gymName.setText(chatMemList.get(position).get("MEM_GENDER").toString());
        tv_tch_chat_clsName.setText(chatMemList.get(position).get("MEM_ADDR").toString());

        try{
            TomcatImg tomcatImg = new TomcatImg();
            String imsi = chatMemList.get(position).get("FILE_SEQ").toString().substring(0, chatMemList.get(position).get("FILE_SEQ").toString().length()-2);
            Log.i("TchChatAdapter:", "file_seq : "+imsi);
            String bitImg = tomcatImg.execute(imsi).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            iv_tch_chat_mem_img.setImageBitmap(bitmap);
        }catch(Exception e){
            e.printStackTrace();
        }

        vo = (AppVO)context.getApplicationContext();
        cv_chat_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vo.setRoomName1(tv_tch_chat_memName.getText().toString());
                Intent intent = new Intent(context, Chat.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
