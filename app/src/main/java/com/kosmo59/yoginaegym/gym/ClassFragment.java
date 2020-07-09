package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kosmo59.yoginaegym.R;

public class ClassFragment extends Fragment {

    private Context context;
    private Button btn_class_detail;

    public ClassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class, container, false);
        context = container.getContext();
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
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
        return view;
    }
}