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
    ArrayList<String> gymNoList;
    ArrayAdapter<String> arrayAdapter;

    AppVO vo = (AppVO) context.getApplicationContext();

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


        /*스피너*/
        gymNameList = new ArrayList<>();
        gymNoList = new ArrayList<>();
        //////////////////////////////// 스피너 DB 연동 /////////////////////////////////////
        for (int i=0; i<clsList.size(); i++){
            gymNameList.add(clsList.get(i).get("CLS_NAME").toString());
            gymNoList.add(clsList.get(i).get("CLS_NO").toString());
        }

        //////////////////////////////// 스피너 DB 연동 /////////////////////////////////////
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, gymNameList);

        spn_tchClass = view.findViewById(R.id.spn_tchClass);
        spn_tchClass.setAdapter(arrayAdapter);
        spn_tchClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                Toast.makeText(context,gymNameList.get(i)+" 매장입니다", Toast.LENGTH_SHORT).show();
                vo.setTch_cho_gym_no(Integer.parseInt(gymNoList.get(i)));
                getTchClsList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        return view;
    }

    public void getTchClsList(){
        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonTchClassList.gym";

        String nowTch = null;
        Map<String, Object> tchMap = new HashMap<>();
        tchMap.put("tch_no", vo.getTchNum());
        tchMap.put("gym_no", vo.getTch_cho_gym_no());
        nowTch = tchMap.toString();
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i("테스트", "nowTch : " + nowTch);
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, nowTch).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);

//        if(result != null){
//            Toast.makeText(container.getContext(), result, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
//        }
        Gson g = new Gson();
        clsList = (List<Map<String, Object>>)g.fromJson(result, listType);
        Log.i("테스트", "clsList.size() : " + clsList.size());
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        TchclassAdapter tchclassAdapter = new TchclassAdapter(mContext, R.layout.tchclasslistview_item, clsList);
        cls_listView.setAdapter(tchclassAdapter);
    }

}
