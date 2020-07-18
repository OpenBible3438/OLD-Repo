package com.kosmo59.yoginaegym.member;

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
import com.kosmo59.yoginaegym.gym.PRDialog;
import com.kosmo59.yoginaegym.gym.PRImageAdapter;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InbodyFragment extends Fragment {
    private Context context;
    private GridView gv_memInbody;
    List<Map<String, Object>> inbodyList = null;
    AppVO vo;

    public InbodyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inbody, container, false);
        context = container.getContext();

        vo = (AppVO) context.getApplicationContext();
        //Image DB 연동
        String result = null;
        String reqUrl = "android/jsonTchClsMemIbd.gym";
        //gym_no 넘겨주기
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("mem_no", vo.getMem_no());
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i("PRImageFragment", "DB 연동 시작");
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        }catch (Exception e){
            Log.i("PRImageFragment", "Exception : "+e.toString());
        }
        Gson g = new Gson();
        inbodyList = (List<Map<String, Object>>)g.fromJson(result, listType);
        InbodyImageAdapter inbodyImageAdapter = new InbodyImageAdapter(context, R.layout.fragment_inbody,inbodyList);
        gv_memInbody = view.findViewById(R.id.gv_memInbody);
        gv_memInbody.setAdapter(inbodyImageAdapter);



        /*gv_inbodyImage = view.findViewById(R.id.gv_memInbody);
        gv_inbodyImage.setAdapter(new InbodyImageAdapter(context));
        gv_inbodyImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(context, position+"번째 사진 클릭", Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        //context this getContext()
                        InbodyDialog inbodyDialog = new InbodyDialog(context);
                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        inbodyDialog.callFunction();
                        break;
                }
            }
        });*/
        return view;
    }
}
