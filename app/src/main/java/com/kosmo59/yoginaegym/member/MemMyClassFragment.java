package com.kosmo59.yoginaegym.member;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

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

public class MemMyClassFragment extends Fragment {

    private Context context;

    public MemMyClassFragment() {
        // Required empty public constructor
    }
    final String Tag = "MemMyClassFragment";
    List<Map<String, Object>> myClassList;
    ListView myClass_listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mem_my_class, container, false);
        context = container.getContext();

        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/myClassList.gym";
        AppVO vo = (AppVO) getActivity().getApplicationContext();
        String nowMem = null;
        Map<String, Object> memMap = new HashMap<>();
        memMap.put("mem_no", vo.mem_no);
        nowMem = memMap.toString();
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i(Tag, "nowMem : " + nowMem);
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, nowMem).get();
        } catch (Exception e){
            Log.i(Tag, "Exception : "+e.toString());
        }
        Log.i(Tag, "톰캣서버에서 읽어온 정보 : "+result);

        if(result != null){
            Toast.makeText(container.getContext(), result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
        }
        Gson g = new Gson();
        myClassList = (List<Map<String, Object>>)g.fromJson(result, listType);
        Log.i(Tag, "myClassList : " + myClassList);
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        MyClassAdapter myClassAdapter = new MyClassAdapter(context, R.layout.myclass_list_item, myClassList);
        myClass_listView = view.findViewById(R.id.myClass_list);
        myClass_listView.setAdapter(myClassAdapter);


        return view;
    }
}
