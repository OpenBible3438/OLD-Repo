package com.kosmo59.yoginaegym.teacher;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.member.MyreviewRegDialog;

public class TchClassFragment extends Fragment {
    private Context context;
    private Button tch_class;
    public TchClassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class, container, false);
        context = container.getContext();
        tch_class = view.findViewById(R.id.tch_class);
        tch_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                TchDialog TchDialog = new TchDialog(context);

                // 커스텀 다이얼로그를 호출한다.
                TchDialog. onTchDialog();


            }
        });

        //return inflater.inflate(R.layout.fragment_my_review, container, false);
        return view;
    }

}
