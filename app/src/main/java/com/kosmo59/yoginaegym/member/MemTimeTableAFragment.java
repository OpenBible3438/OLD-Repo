package com.kosmo59.yoginaegym.member;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.member.calendar.EventDecorator;
import com.kosmo59.yoginaegym.member.calendar.OneDayDecorator;
import com.kosmo59.yoginaegym.member.calendar.SaturdayDecorator;
import com.kosmo59.yoginaegym.member.calendar.SundayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

public class MemTimeTableAFragment extends Fragment {

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
    MaterialCalendarView materialcalendarview;

    public MemTimeTableAFragment() {
        Log.i("테스트", "MemTimeTableAFragment 호출");

        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_mem_time_table_a, container, false);
        Log.i("테스트", "onCreateView 호출");

        materialcalendarview = (MaterialCalendarView) view.findViewById(R.id.calendarView);
        Log.i("테스트", "materialcalendarview : " + materialcalendarview);

        materialcalendarview.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2019, 07, 1)) // 달력의 시작
                .setMaximumDate(CalendarDay.from(2021, 12, 31)) // 달력의 끝
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
        materialcalendarview.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator(),
                oneDayDecorator);

        String[] result = {"2020,03,15", "2020,04,15", "2020,05,15", "2020,06,15", "2020,07,15"};

        new ApiSimulator(result).executeOnExecutor(Executors.newSingleThreadExecutor());

        materialcalendarview.setOnDateChangedListener(new OnDateSelectedListener() {
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
                Toast.makeText(view.getContext(), shot_Day, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        String[] Time_Result;

        ApiSimulator(String[] Time_Result) {
            Log.i("테스트", "ApiSimulator 호출");
            this.Time_Result = Time_Result;
            for (String a : Time_Result) {
                Log.i("Time_Result  : ", "Time_Result : " + a);
            }
        }

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {

            Log.i("테스트", "doInBackground 호출");
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
            Log.i("onPostExecute 호출", "onPostExecute 호출 calendarDays : " + calendarDays);
//            if (isFinishing()) {
//                Log.i("finishing 호출", "finishing 호출");
//                return;
//            }
            Log.i("테스트", "onPostExecute 호출");
            materialcalendarview.addDecorator(new EventDecorator(Color.RED, calendarDays, MemTimeTableAFragment.this));
            Log.i("테스트", "addDecorator 다음 코드");
        }


    }
}
