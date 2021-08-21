package com.kosmo59.yoginaegym.teacher;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TchClassFragment extends Fragment {
    private Context mContext;
    private Context context;
    private ImageButton icon_close;
    private Button btn_tchMemList;

    private Spinner spn_tchClass;
    ArrayList<String> gymNameList;
    ArrayList<Integer> gymNoList;
    ArrayAdapter<String> arrayAdapter;
    final String Tag = "TchClassFragment";
    Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
    AppVO vo = null;

    private ListView cls_listView;
    List<Map<String, Object>> clsList = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


    public TchClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tch_class, container, false);
        context = container.getContext();
        cls_listView = view.findViewById(R.id.cls_list);
        vo =(AppVO) context.getApplicationContext();
        Gson g = new Gson();
        /*스피너*/
        gymNameList = new ArrayList<>();
        gymNoList = new ArrayList<>();
        //////////////////////////////// 스피너 DB 연동 /////////////////////////////////////
        List<Map<String, Object>> gymList = null;
        String gymResult = null;
        String reqUrl = "android/jsonTchGymList.gym";
        String nowTch = null;
        Map<String, Object> tchMap = new HashMap<>();
        tchMap.put("tch_no", vo.getTchNum());
        nowTch = tchMap.toString();
        try {
            TomcatSend tomcatSend = new TomcatSend();
            gymResult = tomcatSend.execute(reqUrl, nowTch).get();
        } catch (Exception e){
            Log.i(Tag, "Exception : "+e.toString());
        }
        Log.i(Tag, "톰캣서버에서 읽어온 정보 : "+gymResult);
        gymList = g.fromJson(gymResult, listType);
        Log.i(Tag, "gymList.size() : " + gymList.size());
        for (int i=0; i<gymList.size(); i++){
            gymNameList.add(gymList.get(i).get("GYM_NAME").toString());
            gymNoList.add(Integer.parseInt((gymList.get(i).get("GYM_NO").toString()).split("\\.")[0]));
        }

        //////////////////////////////// 스피너 DB 연동 끝/////////////////////////////////////
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, gymNameList);

        spn_tchClass = view.findViewById(R.id.spn_tchClass);
        spn_tchClass.setAdapter(arrayAdapter);
        spn_tchClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                Toast.makeText(context,gymNameList.get(i)+" 매장입니다", Toast.LENGTH_SHORT).show();
//                vo.setTch_cho_gym_no(Integer.parseInt(gymNoList.get(i)));
                getTchClsList(gymNoList.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        return view;
    }

    public void getTchClsList(int choGymNo){
        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonTchClassList.gym";

        String nowTch = null;
        Map<String, Object> tchMap = new HashMap<>();
        tchMap.put("tch_no", vo.getTchNum());
        //tchMap.put("gym_no", vo.getTch_cho_gym_no());
        tchMap.put("gym_no", choGymNo);
        nowTch = tchMap.toString();
        Log.i(Tag, "nowTch : " + nowTch);
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, nowTch).get();
        } catch (Exception e){
            Log.i(Tag, "Exception : "+e.toString());
        }
        Log.i(Tag, "톰캣서버에서 읽어온 정보 : "+result);

//        if(result != null){
//            Toast.makeText(container.getContext(), result, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
//        }
        Gson g = new Gson();
        clsList = (List<Map<String, Object>>)g.fromJson(result, listType);
        Log.i(Tag, "clsList.size() : " + clsList.size());
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        TchclassAdapter tchclassAdapter = new TchclassAdapter(mContext, R.layout.tchclasslistview_item, clsList);
        cls_listView.setAdapter(tchclassAdapter);
    }

}
