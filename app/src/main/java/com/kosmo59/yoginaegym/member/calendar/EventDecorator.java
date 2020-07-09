package com.kosmo59.yoginaegym.member.calendar;

import android.util.Log;

import com.kosmo59.yoginaegym.member.MemTimeTableAFragment;
import com.kosmo59.yoginaegym.teacher.TchCalActivity;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Decorate several days with a dot
 */
public class EventDecorator implements DayViewDecorator {

    //private final Drawable drawable;
    private int color;
    private HashSet<CalendarDay> dates;

    public EventDecorator(int color, Collection<CalendarDay> dates, MemTimeTableAFragment context) {
      // drawable = context.getResources().getDrawable(R.layout.more);
        this.color = color;
        this.dates = new HashSet<>(dates);
        Log.i("테스트", "dates : " + dates);
    }

    public EventDecorator(int color, Collection<CalendarDay> dates, TchCalActivity context) {
      // drawable = context.getResources().getDrawable(R.layout.more);
        this.color = color;
        this.dates = new HashSet<>(dates);
        Log.i("테스트", "dates : " + dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        //view.setSelectionDrawable(drawable);
        Log.i("테스트", "decorate 호출");
        Log.i("테스트", "view : " + view);
        view.addSpan(new DotSpan(6, color)); // 날자밑에 점

    }
}
