package com.kosmo59.yoginaegym.teacher;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TchMemListFragment extends Fragment {
    private Context mContext;
    private Context context;

    private ListView mem_listView;
    List<Map<String, Object>> memList = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public TchMemListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_tch_mem_list, container, false);
        context = container.getContext();

        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonTchClassList.gym";

        String nowTch = null;
        Map<String, Object> tchMap = new HashMap<>();
        tchMap.put("tch_no", 1005);/////////////바꿀 코드
        tchMap.put("gym_no", 200903);/////////////바꿀 코드
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

        if(result != null){
            Toast.makeText(container.getContext(), result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
        }
        Gson g = new Gson();
        memList = (List<Map<String, Object>>)g.fromJson(result, listType);
        Log.i("테스트", "clsList.size() : " + memList.size());
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        TchMemListAdaper tchMemListAdaper = new TchMemListAdaper(mContext, R.layout.tchclasslistview_item, memList);
        mem_listView = view.findViewById(R.id.cls_list);
        mem_listView.setAdapter(tchMemListAdaper);

        return view;
    }

}
