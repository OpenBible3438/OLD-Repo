package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kosmo59.yoginaegym.R;

public class GymggunFragment extends Fragment {
    private Context context;
    private CardView teacher_3;

    public GymggunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gymggun, container, false);
        context = container.getContext();
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        teacher_3 = view.findViewById(R.id.teacher_3);
        teacher_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                GymggunDetailDialog gymggunDetailDialog = new GymggunDetailDialog(context);

                // 커스텀 다이얼로그를 호출한다.
                gymggunDetailDialog.openGymggunDetailDialog();
            }
        });
        return view;
    }
}
