package com.kosmo59.yoginaegym.member;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kosmo59.yoginaegym.MainActivity;
import com.kosmo59.yoginaegym.R;

import java.util.ArrayList;

public class MyReviewFragment extends Fragment {

    private Context context;
    private TextView my_review_reg;
    private ImageButton icon_close;
    private Button btn_myReviewReg_ins;

    public MyReviewFragment() {
        // Required empty public constructor



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_review, container, false);

        context = container.getContext();
        // Inflate the layout for this fragment
        my_review_reg = view.findViewById(R.id.my_review_reg);
        my_review_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
//                final Dialog dlg = new Dialog(context);
//
//                // 액티비티의 타이틀바를 숨긴다.
//                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//                // 커스텀 다이얼로그의 레이아웃을 설정한다.
//                dlg.setContentView(R.layout.dialog_my_review_reg);
//                // 커스텀 다이얼로그를 노출한다.
//                dlg.show();
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                MyReviewRegDialog myReviewRegDialog = new MyReviewRegDialog(context);
                myReviewRegDialog.openMyReviewReg();
                // memLogDetailDialog = new MemLogDetailDialog(v.getContext(), Integer.parseInt(mList.get(position).get("_id").toString()));

                // 커스텀 다이얼로그를 호출한다.
                //memLogDetailDialog.openMemLogDetailDialog();
//                ArrayList arrayList = new ArrayList<String>();
//                arrayList.add("수업테스트0");
//                arrayList.add("수업테스트1");
//                arrayList.add("수업테스트2");
//                arrayList.add("수업테스트3");
//                Toast.makeText(dlg.getContext(), arrayList.toString(), Toast.LENGTH_SHORT).show();

//                btn_myReviewReg_ins = dlg.findViewById(R.id.btn_myReviewReg_ins);
//                btn_myReviewReg_ins.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(context,"등록 완료",Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//
//                //다이얼로그 닫기 버튼
//                icon_close = dlg.findViewById(R.id.icon_close);
//                icon_close.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dlg.hide();
//                    }
//                });
            }
        });
        return view;

    }

}
