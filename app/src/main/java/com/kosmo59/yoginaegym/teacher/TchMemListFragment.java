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
import android.widget.Toast;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.gym.ClassDetailDialog;

public class TchMemListFragment extends Fragment {
    private Context context;
    private CardView tch_mem_list;
    private Button btn_tchmemDetail;

    public TchMemListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tch_mem_list, container, false);
        context = container.getContext();
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        tch_mem_list = view.findViewById(R.id.tch_mem_list);
        tch_mem_list.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Toast.makeText(context, "성공", Toast.LENGTH_SHORT).show();
                Toast myToast = Toast.makeText(context.getApplicationContext(),"성공",Toast.LENGTH_SHORT);
                myToast.show();

                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                final Dialog dlg = new Dialog(context);

                출처: https://dhna.tistory.com/220 [호군의 "Code 속으로..."]
                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_tch_mem_info);

                // 커스텀 다이얼로그를 노출한다.
                dlg.show();
            }
        });

        return view;
    }


}
