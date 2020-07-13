package com.kosmo59.yoginaegym.member;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class MemWeekFragment extends Fragment {

    public MemWeekFragment() {
        // Required empty public constructor
    }

    List<Map<String, Object>> memWeekClsList = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("테스트", "MemWeekFragment - onCreateView 호출");
        View view = inflater.inflate(R.layout.fragment_mem_week, container, false);

        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonMemClsList.gym";
        AppVO vo = (AppVO) getActivity().getApplicationContext();
        String nowMem = null;
        Map<String, Object> memMap = new HashMap<>();
        memMap.put("mem_no", vo.mem_no);/////////////바꿀 코드?????
        memMap.put("gym_no", 999);/////////////바꿀 코드
        nowMem = memMap.toString();
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i("테스트", "nowMem : " + nowMem);
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, nowMem).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);

        if(result != null){
            Toast.makeText(container.getContext(), result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
        }
        Gson g = new Gson();
        memWeekClsList = (List<Map<String, Object>>)g.fromJson(result, listType);
        Log.i("테스트", "memWeekClsList : " + memWeekClsList);
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        StringBuilder mon = new StringBuilder();
        StringBuilder tue = new StringBuilder();
        StringBuilder wed = new StringBuilder();
        StringBuilder thu = new StringBuilder();
        StringBuilder fri = new StringBuilder();
        StringBuilder sat = new StringBuilder();
        StringBuilder sun = new StringBuilder();

        for (int i=0; i<memWeekClsList.size(); i++){
            String cls_day = memWeekClsList.get(i).get("CLS_DAY").toString();
            if(cls_day.contains("월")){
                if(i>0) mon.append("\n");
                mon.append(memWeekClsList.get(i).get("CLS_STIME").toString()
                    + " ~ " + memWeekClsList.get(i).get("CLS_ETIME").toString()
                    + " : " + memWeekClsList.get(i).get("CLS_NAME").toString()
                );
            }
            if(cls_day.contains("화")){
                if(i>0) tue.append("\n");
                tue.append(memWeekClsList.get(i).get("CLS_STIME").toString()
                    + " ~ " + memWeekClsList.get(i).get("CLS_ETIME").toString()
                    + " : " + memWeekClsList.get(i).get("CLS_NAME").toString()
                );
            }
            if(cls_day.contains("수")){
                if(i>0) wed.append("\n");
                wed.append(memWeekClsList.get(i).get("CLS_STIME").toString()
                    + " ~ " + memWeekClsList.get(i).get("CLS_ETIME").toString()
                    + " : " + memWeekClsList.get(i).get("CLS_NAME").toString()
                );
            }
            if(cls_day.contains("목")){
                if(i>0) thu.append("\n");
                thu.append(memWeekClsList.get(i).get("CLS_STIME").toString()
                    + " ~ " + memWeekClsList.get(i).get("CLS_ETIME").toString()
                    + " : " + memWeekClsList.get(i).get("CLS_NAME").toString()
                );
            }
            if(cls_day.contains("금")){
                if(i>0) fri.append("\n");
                fri.append(memWeekClsList.get(i).get("CLS_STIME").toString()
                    + " ~ " + memWeekClsList.get(i).get("CLS_ETIME").toString()
                    + " : " + memWeekClsList.get(i).get("CLS_NAME").toString()
                );
            }
            if(cls_day.contains("토")){
                if(i>0) sat.append("\n");
                sat.append(memWeekClsList.get(i).get("CLS_STIME").toString()
                    + " ~ " + memWeekClsList.get(i).get("CLS_ETIME").toString()
                    + " : " + memWeekClsList.get(i).get("CLS_NAME").toString()
                );
            }
            if(cls_day.contains("일")){
                if(i>0) sun.append("\n");
                sun.append(memWeekClsList.get(i).get("CLS_STIME").toString()
                    + " ~ " + memWeekClsList.get(i).get("CLS_ETIME").toString()
                    + " : " + memWeekClsList.get(i).get("CLS_NAME").toString()
                );
            }
        }

        TextView mon_clsList = (TextView)view.findViewById(R.id.mon_clsList);
        TextView tue_clsList = (TextView)view.findViewById(R.id.tue_clsList);
        TextView wed_clsList = (TextView)view.findViewById(R.id.wed_clsList);
        TextView thu_clsList = (TextView)view.findViewById(R.id.thu_clsList);
        TextView fri_clsList = (TextView)view.findViewById(R.id.fri_clsList);
        TextView sat_clsList = (TextView)view.findViewById(R.id.sat_clsList);
        TextView sun_clsList = (TextView)view.findViewById(R.id.sun_clsList);

        mon_clsList.setText(mon);
        tue_clsList.setText(tue);
        wed_clsList.setText(wed);
        thu_clsList.setText(thu);
        fri_clsList.setText(fri);
        sat_clsList.setText(sat);
        sun_clsList.setText(sun);

        return view;
    }
}
