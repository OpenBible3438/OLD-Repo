package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.os.Bundle;

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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymNoticeFragment extends Fragment {

    private final String NOTICE_LOG = "GymNoticeFragment";
    private Context context;
    private ListView lv_gym_notice;
    List<Map<String, Object>> gymNoticeList = null;

    public GymNoticeFragment() {
        // Required empty public constructor
    }
    Context gymProfileActivity = null;
    public GymNoticeFragment(Context gymProfileActivity) {
        this.gymProfileActivity = gymProfileActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gym_notice, container, false);
        context = container.getContext();

        Log.i(NOTICE_LOG, "호출 성공");
        String result = null;
        String reqUrl = "android/jsonGymNoticeList.gym";
        AppVO vo = (AppVO) getActivity().getApplicationContext();
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("gym_no", 1); //gym_no = 1, 일헬스 매장의 공지사항 부르기

        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);

        if(result != null){
            //Toast.makeText(container.getContext(), result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
        }
        Gson g = new Gson();
        gymNoticeList = (List<Map<String, Object>>)g.fromJson(result, listType);
        GymNoticeAdapter gymNoticeAdapter = new GymNoticeAdapter(context, R.layout.gym_notice_item, gymNoticeList);
        lv_gym_notice = view.findViewById(R.id.lv_gym_notice);
        lv_gym_notice.setAdapter(gymNoticeAdapter);

        return view;
    }
}
