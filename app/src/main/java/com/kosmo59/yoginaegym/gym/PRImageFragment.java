package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PRImageFragment extends Fragment {

    private Context context;
    private GridView gv_prImage;
    private GridView prImage;
    List<Map<String, Object>> prImgLsit = null;
    JSONObject jsonObject = null;
    JSONArray jsonArray = null;
    AppVO vo;

    public PRImageFragment() {
        // Required empty public constructor
    }

    Context gymProfileActivity = null;

    public PRImageFragment(Context gymProfileActivity) {
        this.gymProfileActivity = gymProfileActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p_r_image, container, false);
        context = container.getContext();
        vo = (AppVO) context.getApplicationContext();
        //Image DB 연동
        String result = null;
        String reqUrl = "android/jsonContentsList.gym";
        //gym_no 넘겨주기
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("gym_no", vo.getGym_no());
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i("PRImageFragment", "DB 연동 시작");
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        }catch (Exception e){
            Log.i("PRImageFragment", "Exception : "+e.toString());
        }
        Log.i("PRImageFragment", "톰캣서버에서 읽어온 정보 : "+jsonArray);
        Gson g = new Gson();
        prImgLsit = (List<Map<String, Object>>)g.fromJson(result, listType);
        PRImageAdapter prImageAdapter = new PRImageAdapter(context, R.layout.fragment_p_r_image,prImgLsit);
        prImage = view.findViewById(R.id.gv_prImage);
        prImage.setAdapter(prImageAdapter);

        //gv_prImage = view.findViewById(R.id.gv_prImage);
        //gv_prImage.setAdapter(new PRImageAdapter(context));
        /*gv_prImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                *//* 사진 누르면 컨텐츠 자세히보기 다이얼로그 수정해야됨 !!! *//*

                //Toast.makeText(context, position+"번째 사진 클릭", Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        //context this getContext()
                        PRDialog prDialog = new PRDialog(context);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        prDialog.callFunction();
                        break;
                }
            }
        });*/

        return view;
    }
}
