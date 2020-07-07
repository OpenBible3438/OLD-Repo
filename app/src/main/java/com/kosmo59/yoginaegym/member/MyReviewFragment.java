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
                //Toast.makeText(context,"등록 클릭.",Toast.LENGTH_LONG).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("등록하시겠습니까?.");
                alertDialogBuilder.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(context,"등록되었습니다.",Toast.LENGTH_LONG).show();
                    }
                });
                alertDialogBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"취소되었습니다.",Toast.LENGTH_LONG).show();
                        //finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        //return inflater.inflate(R.layout.fragment_my_review, container, false);
        return view;
    }

}
