package com.kosmo59.yoginaegym.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kosmo59.yoginaegym.R;
import android.os.Bundle;

public class MemclassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memclass);

        MemberClassPagerAdapter memberClassPagerAdapter = new MemberClassPagerAdapter(getSupportFragmentManager());
        ViewPager vp_memClass = findViewById(R.id.vp_memClass);
        TabLayout tl_memClass = findViewById(R.id.tl_memClass);
        vp_memClass.setAdapter(memberClassPagerAdapter);
        tl_memClass.setupWithViewPager(vp_memClass);
    }

    private class MemberClassPagerAdapter extends FragmentPagerAdapter{

        public MemberClassPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new MemWeekFragment();
                case 1:
                    return new MemMyClassFragment();
                case 2:
                    return new MemLogFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "수업 시간표";
                case 1:
                    return "수업정보";
                case 2:
                    return "일지";
            }
            return null;
        }
    }
}
