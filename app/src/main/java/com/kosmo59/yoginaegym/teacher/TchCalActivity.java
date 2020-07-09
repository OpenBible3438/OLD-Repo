package com.kosmo59.yoginaegym.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.member.calendar.EventDecorator;
import com.kosmo59.yoginaegym.member.calendar.OneDayDecorator;
import com.kosmo59.yoginaegym.member.calendar.SaturdayDecorator;
import com.kosmo59.yoginaegym.member.calendar.SundayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

public class TchCalActivity extends AppCompatActivity {

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
    MaterialCalendarView materialCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_cal);
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
                Toast.makeText(getApplicationContext(), shot_Day, Toast.LENGTH_SHORT).show();
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
}

