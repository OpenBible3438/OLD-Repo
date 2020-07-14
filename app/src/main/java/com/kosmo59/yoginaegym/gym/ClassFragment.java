package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassFragment extends Fragment {
    final String GYM_CLASS_LOG = "GymClassListTomcat";
    private Context context;
    private ListView lv_gym_class;
    List<Map<String, Object>> gymClassList = null;

    public ClassFragment() {
        // Required empty public constructor
    }
    Context gymProfileActivity = null;

    public ClassFragment(Context gymProfileActivity) {
        this.gymProfileActivity = gymProfileActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class, container, false);
        context = container.getContext();

        /* 수업 리스트 DB 연동 */
        Log.i(GYM_CLASS_LOG, "호출성공");
        String result = null;
        String reqUrl = "android/jsonGymClassList.gym";
        Map<String, Object> pMap = new HashMap<>();
        AppVO vo = (AppVO) getActivity().getApplicationContext();
        pMap.put("gym_no", vo.gym_no);
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);

        if(result != null){
            Toast.makeText(container.getContext(), "수업리스트 호출 성공", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
        }
        Gson g = new Gson();
        gymClassList = (List<Map<String, Object>>)g.fromJson(result, listType);
        ClassAdapter classAdapter = new ClassAdapter(context, R.layout.gym_class_item, gymClassList);
        lv_gym_class = view.findViewById(R.id.lv_gym_class);
        lv_gym_class.setAdapter(classAdapter);

        /* 자세히보기 다이얼로그 호출 부분 */
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        /*
        btn_class_detail = view.findViewById(R.id.btn_class_detail);
        btn_class_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                ClassDetailDialog classDetailDialog = new ClassDetailDialog(context);

                // 커스텀 다이얼로그를 호출한다.
                classDetailDialog.openClassDetailDialog();
            }
        });

         */
        return view;
    }
}