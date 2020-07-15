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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.GymDBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MemLogRegDialog {
    private Context context;
    private ImageButton icon_close;
    private ImageButton icon_date;
    private ImageButton icon_stime;
    private ImageButton icon_etime;

    private EditText et_log_cont;
    private EditText et_log_title;
    private TextView tv_reg_date;
    private TextView tv_exDate;
    private TextView tv_stime;
    private TextView tv_etime;
    private Button btn_logDetail_ins;
    Fragment memlog;
    GymDBHelper gymDBHelper = null;
    SQLiteDatabase db = null;
    AppVO vo = null;
    int hour = 0, minute = 0;
    Dialog dlg = null;
    public MemLogRegDialog(Context context, Fragment memlog) {
        this.context = context;
        this.memlog = memlog;
    }

    public void openMemLogRegDialog() {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        dlg = new Dialog(context);
        gymDBHelper = new GymDBHelper(dlg.getContext());
        db = gymDBHelper.getWritableDatabase();
        vo = (AppVO) dlg.getContext().getApplicationContext();

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_mem_log_reg);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        //내용을 입력할 EditView 찾기
        et_log_cont = dlg.findViewById(R.id.et_log_cont);

        //일지 제목을 입력할 EditView 찾기
        et_log_title = dlg.findViewById(R.id.et_log_title);


        //운동일 찍힐 TextView id찾기
        tv_exDate = dlg.findViewById(R.id.tv_exDate);

        //시작시간 찍힐 tv_stime id찾기
        tv_stime = dlg.findViewById(R.id.tv_stime);

        //종료시간 찍힐 tv_stime id찾기
        tv_etime = dlg.findViewById(R.id.tv_etime);

        //등록일 지정
        //등록일 찍힐 TextView id 찾기
        tv_reg_date = dlg.findViewById(R.id.tv_reg_date);
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        String getTime = simpleDate.format(mDate);
        tv_reg_date.setText(getTime);

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

        //시작시간 지정
        icon_stime = dlg.findViewById(R.id.icon_stime);
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

        //종료시간 지정
        icon_etime = dlg.findViewById(R.id.icon_etime);
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


        //닫기 버튼
        icon_close = dlg.findViewById(R.id.icon_close);
        icon_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.hide();
            }
        });

        btn_logDetail_ins = dlg.findViewById(R.id.btn_logDetail_ins);
        btn_logDetail_ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log_insAction();
            }
        });

    }//end of openMemLogRegDialog


    /* 운동일 확인 버튼 눌렀을 때 */
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

    /*tv_logRegDate에 다이얼로그에서 설정한 날짜로 바꿔주기*/
    private void updateTv_date() {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.KOREA);
        tv_exDate.setText(sdf.format(calendar.getTime()));
    }

    //등록 버튼 눌렀을 때
    public void log_insAction(){
        Log.i("테스트", "lof_insAction() 호출");
        String log_cont = et_log_cont.getText().toString();
        String log_title = et_log_title.getText().toString();
        String ex_date = tv_exDate.getText().toString();
        String logRegDate = tv_reg_date.getText().toString();
        String stime = tv_stime.getText().toString();
        String etime = tv_etime.getText().toString();
        int mem_no = vo.mem_no;

        String mem_log_ins = "INSERT INTO mem_log (mem_no, reg_date, ex_date, log_title, ex_stime, ex_etime, log_cont)" +
                "VALUES ("+mem_no+", '"+logRegDate+"', '"+ex_date+"', '"+log_title+"', '"+stime+"', '"+etime+"', '"+log_cont+"')";
        Log.i("테스트", "mem_log_ins : " + mem_log_ins);
        db.execSQL(mem_log_ins);
        Cursor cursor = db.rawQuery("SELECT * FROM mem_log", null);
        while(cursor.moveToNext()){
            Log.i("테스트", cursor.getString(0)+ ", " + cursor.getString(1) + ", " + cursor.getString(2)
                    + ", " + cursor.getString(3)+ ", " + cursor.getString(4)+ ", " + cursor.getString(5)
                    + ", " + cursor.getString(6)+ ", " + cursor.getString(7));
            dlg.dismiss();
            /////***********************등록되었습니다 알림창 띄워주기*******************///////
            /////***********************일지 목록 새로 고침 처리 해줘야 한다..!*******************///////
            (memlog).onResume();
        }
    }
}
