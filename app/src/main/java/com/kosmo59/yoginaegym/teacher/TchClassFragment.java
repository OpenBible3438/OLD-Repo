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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
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

public class TchClassFragment extends Fragment {
    private Context mContext;
/*    private ClsAdapter clsAdapter;*/

    private CardView tch_class;
    private ListView cls_listView;

    List<Map<String, Object>> clsList = null;
    public TchClassFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("테스트", "TchClassFragment - onCreateView 호출");
        View view = inflater.inflate(R.layout.fragment_tch_class, container, false);
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonTchClassList.gym";

        String nowTch = null;
        Map<String, Object> tchMap = new HashMap<>();
        tchMap.put("tch_no", 2);
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
        clsList = (List<Map<String, Object>>)g.fromJson(result, listType);

        tchclassAdapter tchclassAdapter = new tchclassAdapter(mContext, R.layout.tchclasslistview_item, clsList);
        cls_listView = view.findViewById(R.id.cls_list);
        cls_listView.setAdapter(tchclassAdapter);

        return view;
    }

}
