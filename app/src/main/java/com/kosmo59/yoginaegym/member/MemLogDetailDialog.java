package com.kosmo59.yoginaegym.member;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.GymDBHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MemLogDetailDialog {
    private Context context;
    private ImageButton icon_close;
    private ImageButton icon_date;
    private ImageButton icon_stime;
    private ImageButton icon_etime;
    private EditText et_log_cont;
    private TextView tv_reg_date;
    private EditText et_log_title;
    private TextView tv_stime;
    private TextView tv_etime;
    private Button btn_logDetail_upd;
    int hour = 0, minute = 0;
    int _id = 0;
    GymDBHelper gymDBHelper = null;
    SQLiteDatabase db = null;
    AppVO vo = null;
    public MemLogDetailDialog(Context context, int _id) {
        this.context = context;
        this._id = _id;
    }

    public void openMemLogDetailDialog() {

        gymDBHelper = new GymDBHelper(this.context);
        db = gymDBHelper.getWritableDatabase();
        vo = (AppVO) this.context.getApplicationContext();


        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_mem_log_detail);

        //---다이얼로그 화면 사이즈 조정 시작
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
        //---다이얼로그 화면 사이즈 조정 끝


        // 커스텀 다이얼로그를 노출한다.
        dlg.show();


        //내용
        et_log_cont = dlg.findViewById(R.id.et_log_cont);

        //일지 제목
        et_log_title = dlg.findViewById(R.id.et_log_title);

        //등록일
        tv_reg_date = dlg.findViewById(R.id.tv_reg_date);

        //운동일 찍힐 EditText id찾기
        tv_logDetailDate = dlg.findViewById(R.id.tv_logDetailDate);

        //시작시간 찍힐 tv_stime id찾기
        tv_stime = dlg.findViewById(R.id.tv_stime);
        icon_stime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //openTimePiker();
                TimePickerDialog timePickerDialog = new TimePickerDialog(context, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TextView에 선택 시간 찍어주기
                        tv_stime.setText(hourOfDay+":"+minute+":00");
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        //종료시간 찍힐 tv_stime id찾기
        tv_etime = dlg.findViewById(R.id.tv_etime);
        icon_etime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //openTimePiker();
                TimePickerDialog timePickerDialog = new TimePickerDialog(context, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TextView에 선택 시간 찍어주기
                        String hour = " ";
                        String day = " ";
                        if(hourOfDay < 10) hour = "0"+hourOfDay;
                        if(hourOfDay < 10) day = "0"+hourOfDay;
                        tv_etime.setText(hour+":"+day+":00");
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }
        });

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
        
        //수정버튼
        btn_logDetail_upd = dlg.findViewById(R.id.btn_logDetail_upd);
        btn_logDetail_upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_log(dlg);
            }
        });
        ///////////////////////////////SQLite /////////////////////////////////////////////
        String log_sel = "SELECT _id, reg_date, ex_date, log_title, ex_stime, ex_etime, log_cont" +
                " FROM mem_log" +
                " WHERE _id ="+ _id +
                " ORDER BY ex_date desc";
        Log.i("테스트", "log_sel : " + log_sel);
        Cursor cursor = db.rawQuery(log_sel, null);
        if (cursor.moveToNext()){
            int cnt=1;
            Log.i("테스트", "tv_reg_date : " + tv_reg_date);
            tv_reg_date.setText(cursor.getString(cnt++));
            tv_logDetailDate.setText(cursor.getString(cnt++));
            et_log_title.setText(cursor.getString(cnt++));
            tv_stime.setText(cursor.getString(cnt++));
            tv_etime.setText(cursor.getString(cnt++));
            et_log_cont.setText(cursor.getString(cnt++));
        }
        ///////////////////////////////SQLite 끝/////////////////////////////////////////////
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
    private TextView tv_logDetailDate;
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

    private void update_log(Dialog dlg) {
        String log_upd = "UPDATE mem_log SET ex_date='" + tv_logDetailDate.getText().toString()
                       + "', log_title = '" + et_log_title.getText().toString()
                       + "', ex_stime = '" + tv_stime.getText().toString()
                       + "', ex_etime = '" + tv_etime.getText().toString()
                       + "', log_cont = '" + et_log_cont.getText().toString() + "'"
                       + " WHERE _id = " + _id;
        Log.i("테스트", "log_upd : " + log_upd);
        db.execSQL(log_upd);
        dlg.dismiss();
    }

    //운동일을 선택한 날짜로 표시하기
    private void updateTv_date() {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.KOREA);
        tv_logDetailDate.setText(sdf.format(calendar.getTime()));
    }


}
