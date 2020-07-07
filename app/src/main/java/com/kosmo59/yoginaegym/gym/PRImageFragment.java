package com.kosmo59.yoginaegym.gym;

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

public class PRImageFragment extends Fragment {

    private Context context;
    private GridView gv_prImage;

    public PRImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p_r_image, container, false);

        context = container.getContext();
        gv_prImage = view.findViewById(R.id.gv_prImage);
        gv_prImage.setAdapter(new PRImageAdapter(context));
        gv_prImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, position+"번째 사진 클릭", Toast.LENGTH_SHORT).show();
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
        });

        return view;
    }
}
