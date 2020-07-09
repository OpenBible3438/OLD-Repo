package com.kosmo59.yoginaegym.member;

import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.gym.ClassDetailDialog;

public class MemLogFragment extends Fragment {
    private Context context;
    private CardView dailyRecord_1;
    private CardView dailyRecord_reg;

    public MemLogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mem_log, container, false);
        context = container.getContext();
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        dailyRecord_1 = view.findViewById(R.id.dailyRecord_1);
        dailyRecord_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                MemLogDetailDialog memLogDetailDialog = new MemLogDetailDialog(context);

                // 커스텀 다이얼로그를 호출한다.
                memLogDetailDialog.openMemLogDetailDialog();
            }
        });
        dailyRecord_reg = view.findViewById(R.id.dailyRecord_reg);
        dailyRecord_reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                MemLogRegDialog memLogRegDialog = new MemLogRegDialog(context);

                // 커스텀 다이얼로그를 호출한다.
                memLogRegDialog.openMemLogRegDialog();
            }
        });

        return view;
    }
}
