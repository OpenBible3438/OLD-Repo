package com.kosmo59.yoginaegym.gym;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

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
    Context gymSearchActivity = null;
    public GymSearchAdapter(Context gymSearchActivity, Context context, int resource, List<Map<String, Object>> gymList) {
        super(context, resource, gymList);
        this.gymSearchActivity = gymSearchActivity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
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
        ListView s_gymList = (ListView)convertView.findViewById(R.id.s_gymList);
        CardView s_gym_card =(CardView)convertView.findViewById(R.id.s_gym_card);
        Log.i("테스트", "convertView : " + convertView);
        Log.i("테스트", "s_gymList : " + s_gymList);
//        s_gym_card.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Log.i("테스트", "onItemClick() 호출");
//                // 상세정보 화면으로 이동하기(인텐트 날리기)
//                // 1. 다음화면을 만든다
//                // 2. AndroidManifest.xml 에 화면을 등록한다
//                // 3. Intent 객체를 생성하여 날린다
//
//                // intent 객체에 데이터를 실어서 보내기
//                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
//                Log.i("테스트", "gym_no : " + mList.get(position).get("gym_no").toString());
//
//            }
//        });
        final View finalConvertView = convertView;
        s_gym_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                Log.i("테스트", "클릭");

                Log.i("테스트", "onItemClick() 호출");
                Log.i("테스트", "mList : " + mList);
                Log.i("테스트", "position : " + position);
                Log.i("테스트", "gym_no : " + mList.get(position).get("GYM_NO").toString());

                Intent intent = new Intent(
                        finalConvertView.getContext(), // 현재화면의 제어권자
                        GymProfileActivity.class); // 다음넘어갈 화면

                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                Log.i("테스트", "gym_no : " + mList.get(position).get("GYM_NO").toString());
                intent.putExtra("title", mList.get(position).get("GYM_NO").toString());

                gymSearchActivity.startActivity(intent);


            }
        });

        s_gym_name.setText(mList.get(position).get("GYM_NAME").toString());
        s_gym_addr.setText(mList.get(position).get("GYM_ADDR").toString());
        s_gym_tel.setText(mList.get(position).get("GYM_TEL").toString());


        return convertView;
    }


}
