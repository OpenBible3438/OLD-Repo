package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosmo59.yoginaegym.MainActivity;
import com.kosmo59.yoginaegym.R;

public class MyReviewFragment extends Fragment {

    private Context context;
    private Button btn_revIns;

    public MyReviewFragment() {
        // Required empty public constructor


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_review, container, false);

        context = container.getContext();
        // Inflate the layout for this fragment
        btn_revIns = view.findViewById(R.id.btn_revIns);
        btn_revIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                MyreviewRegDialog myreviewRegDialog = new MyreviewRegDialog(context);

                // 커스텀 다이얼로그를 호출한다.
                myreviewRegDialog.openMyReviewReg();


            }
        });
        //return inflater.inflate(R.layout.fragment_my_review, container, false);
        return view;

    }

}
