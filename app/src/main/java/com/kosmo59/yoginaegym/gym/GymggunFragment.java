package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymggunFragment extends Fragment {
    private Context context;


    public GymggunFragment() {
        // Required empty public constructor
    }
    Context gymProfileActivity = null;

    public GymggunFragment(Context gymProfileActivity) {
        this.gymProfileActivity = gymProfileActivity;
    }
    private Context mContext;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }
    private ListView tch_listView;
    List<Map<String, Object>> tchList = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gymggun, container, false);
        context = container.getContext();

        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonTchList.gym";
        AppVO vo = (AppVO) getActivity().getApplicationContext();
        String nowMem = null;
        Map<String, Object> memMap = new HashMap<>();
        memMap.put("gym_no", vo.gym_no);
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
//
//        if(result != null){
//            Toast.makeText(container.getContext(), result, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
//        }
        Gson g = new Gson();
        tchList = (List<Map<String, Object>>)g.fromJson(result, listType);
        ////////////////////////////////////DB 연동 끝////////////////////////////////////
        GymggunListAdapter tchListAdapter = new GymggunListAdapter(mContext, R.layout.gymggun_list_item, tchList);
        tch_listView = view.findViewById(R.id.tch_listView);
        tch_listView.setAdapter(tchListAdapter);




        return view;
    }
}
