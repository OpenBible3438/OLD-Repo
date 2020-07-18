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

public class GymReviewFragment extends Fragment {
    private Context mContext;

    private ListView gym_reviewList;
    List<Map<String, Object>> reviewList = null;
    final String Tag = "GymReviewFragment";

    public GymReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    Context gymProfileActivity = null;
    public GymReviewFragment(Context gymProfileActivity) {
        this.gymProfileActivity = gymProfileActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gym_review, container, false);
        //context = container.getContext();

        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonGymReviewList.gym";
        AppVO vo = (AppVO)mContext.getApplicationContext();
        String nowTch = null;
        Map<String, Object> tchMap = new HashMap<>();
        //tchMap.put("tch_no", 1005);/////////////바꿀 코드
        tchMap.put("gym_no", vo.getGym_no());/////////////바꿀 코드
        Log.i(Tag, "vo.gym_no : " + vo.getGym_no());
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
        reviewList = (List<Map<String, Object>>)g.fromJson(result, listType);
        Log.i("테스트", "clsList.size() : " + reviewList.size());
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        GymReviewAdapter gymReviewAdapter = new GymReviewAdapter(mContext, R.layout.gymreviewlistview_item, reviewList);
        gym_reviewList = view.findViewById(R.id.gym_reviewList);
        gym_reviewList.setAdapter(gymReviewAdapter);
        return view;
    }
}
