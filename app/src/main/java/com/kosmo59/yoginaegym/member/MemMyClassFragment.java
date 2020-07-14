package com.kosmo59.yoginaegym.member;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosmo59.yoginaegym.R;

import java.util.ArrayList;

public class MemMyClassFragment extends Fragment {
    Button btn_memMyClass;
    private Context context;
    private ImageButton icon_close;

    private Spinner spn_memMyClass;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;


    public MemMyClassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mem_my_class, container, false);
        context = container.getContext();

        arrayList = new ArrayList<>();
        arrayList.add("여기 내짐");
        arrayList.add("터짐");
        arrayList.add("마음가짐");

        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, arrayList);

        spn_memMyClass = view.findViewById(R.id.spn_memMyClass);
        spn_memMyClass.setAdapter(arrayAdapter);
        spn_memMyClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                Toast.makeText(context,arrayList.get(i)+" 매장입니다", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //자세히 보기 버튼
        btn_memMyClass = view.findViewById(R.id.btn_memMyClass);
        btn_memMyClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                final Dialog dlg = new Dialog(context);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_mem_my_class_detail);

                // 커스텀 다이얼로그를 노출한다.
                dlg.show();

                icon_close = dlg.findViewById(R.id.icon_close);
                icon_close.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        dlg.hide();
                    }
                });
            }
        });
        return view;
    }
}
