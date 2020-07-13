package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class GymSearchAdapter extends ArrayAdapter {


    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;




    public GymSearchAdapter(Context context, int resource, List<Map<String, Object>> gymList) {
        super(context, resource, gymList);
        this.mContext = context;
        this.mList = gymList;
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
        CircleImageView s_gym_img = (CircleImageView) convertView.findViewById(R.id.s_gym_img);
        TextView s_gym_name = (TextView) convertView.findViewById(R.id.s_gym_name);
        TextView s_gym_addr = (TextView) convertView.findViewById(R.id.s_gym_addr);
        TextView s_gym_tel = (TextView) convertView.findViewById(R.id.s_gym_tel);
//
//        ////////////////////////////////////DB 연동 시작////////////////////////////////////
//        String result = null;
//        String reqUrl = "main/getImages.gym";
//        String nowGym = null;
//        Map<String, Object> memMap = new HashMap<>();
//        memMap.put("gym_no", mList.get(position).get("GYM_NO");
//        memMap.put("file_seq", mList.get(position).get("FILE_SEQ");
//        nowGym = memMap.toString();
//        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
//        Log.i("테스트", "nowGym : " + nowGym);
//        try {
//            TomcatSend tomcatSend = new TomcatSend();
//            result = tomcatSend.execute(reqUrl, nowGym).get();
//        } catch (Exception e){
//            Log.i("테스트", "Exception : "+e.toString());
//        }
//        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);
//
//        if(result != null){
//            Toast.makeText(getContext().getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getContext().getApplicationContext(), "문제 발생.", Toast.LENGTH_LONG).show();
//        }
//        ////////////////////////////////////DB 연동 끝////////////////////////////////////



        s_gym_name.setText(mList.get(position).get("GYM_NAME").toString());
        s_gym_addr.setText(mList.get(position).get("GYM_ADDR").toString());
        s_gym_tel.setText(mList.get(position).get("GYM_TEL").toString());
        return convertView;
    }


}
