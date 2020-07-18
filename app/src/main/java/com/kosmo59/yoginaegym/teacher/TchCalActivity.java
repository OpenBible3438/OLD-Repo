package com.kosmo59.yoginaegym.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.member.MemLogFragment;
import com.kosmo59.yoginaegym.member.MemTimeTableAFragment;
import com.kosmo59.yoginaegym.member.calendar.EventDecorator;
import com.kosmo59.yoginaegym.member.calendar.OneDayDecorator;
import com.kosmo59.yoginaegym.member.calendar.SaturdayDecorator;
import com.kosmo59.yoginaegym.member.calendar.SundayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

public class TchCalActivity extends AppCompatActivity {
    AppVO vo = null;
    ImageView iv_memQr = null;
    TextView tv_memQrName=null;

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
    MaterialCalendarView materialCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_cal);

        TchCalPagerAdapter tchCalPagerAdapter = new TchCalPagerAdapter(getSupportFragmentManager());

        vo = (AppVO) getApplicationContext();

        materialCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView_tch);

        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2019, 07, 1)) // 달력의 시작
                .setMaximumDate(CalendarDay.from(2021, 11, 31)) // 달력의 끝
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator(),
                oneDayDecorator);

        String[] result = {"2020,03,15", "2020,04,15", "2020,05,15", "2020,06,15", "2020,07,15"};

        new ApiSimulator(result).executeOnExecutor(Executors.newSingleThreadExecutor());

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                int Year = date.getYear();
                int Month = date.getMonth() + 1;
                int Day = date.getDay();

                Log.i("Year test", Year + "");
                Log.i("Month test", Month + "");
                Log.i("Day test", Day + "");

                String shot_Day = Year + "," + Month + "," + Day;

                Log.i("shot_Day test", shot_Day + "");
                //materialCalendarView.clearSelection();
//                Toast.makeText(getApplicationContext(), shot_Day, Toast.LENGTH_SHORT).show();
            }
        });

        /* 하단바 */
        BottomNavigationView bottom = findViewById(R.id.bottom_nav);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        TchCalActivity.super.onBackPressed();
                        break;
                    case R.id.bot_nav_qr:
                        //다이얼로그 초기화
                        final Dialog dlg = new Dialog(TchCalActivity.this);
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dlg.setContentView(R.layout.dialog_mem_qr);
                        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
                        //QR 코드 생성
                        String data = vo.getTchId(); //mem_id로 QR코드 생성
                        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                        try {
                            BitMatrix bitMatrix = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 300,300);
                            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                            Log.i("QR Make", "생성된 QR Bitmap : "+bitmap.toString());
                            iv_memQr = dlg.findViewById(R.id.iv_memQr);
                            tv_memQrName = dlg.findViewById(R.id.tv_memQrName);
                            iv_memQr.setImageBitmap(bitmap); //만들어진 QR코드 붙이기
                            tv_memQrName.setText(vo.getTchName()+" 강사님");
                        }catch (Exception e){
                            Log.i("QR Make", e.toString());
                        }
                        dlg.show();
                        break;
                    case R.id.bot_nav_cont:
                        Intent intent_cont = new Intent(TchCalActivity.this, TchContentActivity.class);
                        startActivity(intent_cont);
                        TchCalActivity.this.finish();
                        break;
                    case R.id.bot_nav_msg:
                        Intent intent_msg = new Intent(TchCalActivity.this, TchChatListActivity.class);
                        startActivity(intent_msg);
                        TchCalActivity.this.finish();
                        break;

                }
                return false;
            }
        });
    }

    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        String[] Time_Result;

        ApiSimulator(String[] Time_Result) {
            this.Time_Result = Time_Result;
            for (String a : Time_Result) {
                Log.i("Time_Result  : ", "Time_Result : " + a);
            }
        }

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {

            Log.i("doInBackground 호출", "doInBackground 호출");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Calendar calendar = Calendar.getInstance();
            ArrayList<CalendarDay> dates = new ArrayList<>();

            /*특정날짜 달력에 점표시해주는곳*/
            /*월은 0이 1월 년,일은 그대로*/
            //string 문자열인 Time_Result 을 받아와서 ,를 기준으로짜르고 string을 int 로 변환
            for (int i = 0; i < Time_Result.length; i++) {
                CalendarDay day = null;
                String[] time = Time_Result[i].split(",");
                int year = Integer.parseInt(time[0]);
                int month = Integer.parseInt(time[1]);
                int dayy = Integer.parseInt(time[2]);

                calendar.set(year, month - 1, dayy);
                day = CalendarDay.from(calendar);
                dates.add(day);
            }


            Log.i("dates : ", "dates : " + dates);
            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);
            Log.i("onPostExecute 호출", "onPostExecute 호출 calenderDays : " + calendarDays);
            if (isFinishing()) {
                Log.i("finishing 호출", "finishing 호출");
                return;
            }

            materialCalendarView.addDecorator(new EventDecorator(Color.RED, calendarDays, TchCalActivity.this));
        }


    }

    private class TchCalPagerAdapter extends FragmentPagerAdapter {

        public TchCalPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new TchCalFragment();
                case 1:
                    return new TchLogFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "월별보기";
                case 1:
                    return "일지";
            }
            return null;
        }

        @Override

        public int getItemPosition(Object object) {

            return POSITION_NONE;

        }

    }
}

