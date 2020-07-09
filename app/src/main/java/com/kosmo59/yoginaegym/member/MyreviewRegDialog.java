package com.kosmo59.yoginaegym.member;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosmo59.yoginaegym.R;

import java.lang.reflect.Array;


public class MyreviewRegDialog {
    private Context context;
    private Spinner reviewInsSpinner;
    private String className = "";

    public MyreviewRegDialog(Context context) {
        this.context = context;
    }

    public void openMyReviewReg() {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_my_review_reg);

        // 커스텀 다이얼로그 사이즈 조정
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dlg.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        Window window = dlg.getWindow();
        window.setAttributes(lp);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();
        reviewInsSpinner = dlg.findViewById(R.id.reviewInsSpinner);

        ArrayAdapter selectClassAdapter = ArrayAdapter.createFromResource(context, R.array.selectClass, android.R.layout.simple_spinner_dropdown_item);
        reviewInsSpinner.setAdapter(selectClassAdapter);
        reviewInsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                className = reviewInsSpinner.getItemAtPosition(position).toString();
                /*Toast.makeText(context, className+"선택", Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
