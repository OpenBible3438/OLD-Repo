package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;
import com.kosmo59.yoginaegym.teacher.TchclassAdapter;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayListFragment extends Fragment {
    private Context mContext;
    /*    private ClsAdapter clsAdapter;*/

    private ListView pay_listView;
    List<Map<String, Object>> memPayList = null;
    public PayListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("테스트", "PayListFragment - onCreateView 호출");
        View view = inflater.inflate(R.layout.fragment_pay_list, container, false);
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonMemPayList.gym";
        AppVO vo = (AppVO) getActivity().getApplicationContext();
        String nowMem = null;
        Map<String, Object> memMap = new HashMap<>();
        memMap.put("mem_no", vo.mem_no);/////////////바꿀 코드
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
        memPayList = (List<Map<String, Object>>)g.fromJson(result, listType);
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        PayListAdapter payListAdapter = new PayListAdapter(mContext, R.layout.paylistview_item, memPayList);
        pay_listView = view.findViewById(R.id.pay_list);
        pay_listView.setAdapter(payListAdapter);

        return view;

    }
}
