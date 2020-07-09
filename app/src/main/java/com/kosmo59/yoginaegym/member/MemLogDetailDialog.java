package com.kosmo59.yoginaegym.member;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.kosmo59.yoginaegym.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MemLogDetailDialog {
    private Context context;
    private ImageButton icon_close;
    private ImageButton icon_date;

    public MemLogDetailDialog(Context context) {
        this.context = context;
    }

    public void openMemLogDetailDialog() {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_mem_log_detail);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        //운동일 찍힐 EditText id찾기
        tv_logDetailDate = dlg.findViewById(R.id.tv_logDetailDate);

        //운동일 지정
        icon_date = dlg.findViewById(R.id.icon_date);
        icon_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다이얼로그 떴을 때 현재 날짜로 띄우기
                new DatePickerDialog(context, android.R.style.Theme_DeviceDefault_Light_Dialog, datePicker
                        , calendar.get(Calendar.YEAR)
                        , calendar.get(Calendar.MONTH)
                        , calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        icon_close = dlg.findViewById(R.id.icon_close);
        icon_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.hide();
            }
        });
    }

    /* 운동일 */
    private EditText tv_logDetailDate;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateTv_date();
        }
    };

    /*tv_logDetailDate에 다이얼로그로 설정한 날짜로 바꿔주기*/
    private void updateTv_date() {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.KOREA);
        tv_logDetailDate.setText(sdf.format(calendar.getTime()));
    }
}
