package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.gym.PRDialog;
import com.kosmo59.yoginaegym.gym.PRImageAdapter;


public class InbodyFragment extends Fragment {

    private Context context;
    private GridView gv_inbodyImage;

    public InbodyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inbody, container, false);

        context = container.getContext();
        gv_inbodyImage = view.findViewById(R.id.gv_memInbody);
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
        });
        return view;
    }
}
