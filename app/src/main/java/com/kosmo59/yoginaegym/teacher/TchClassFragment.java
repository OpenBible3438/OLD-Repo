package com.kosmo59.yoginaegym.teacher;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.kosmo59.yoginaegym.R;

public class TchClassFragment extends Fragment {
    private Context context;
    private CardView tch_class;

    public TchClassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tch_class, container, false);
        context = container.getContext();
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        tch_class = view.findViewById(R.id.tch_class);
        tch_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                final Dialog dlg = new Dialog(context);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.fragment_tch_mem_list);

                // 커스텀 다이얼로그를 노출한다.
                dlg.show();
            }
        });
        return view;
    }




}
