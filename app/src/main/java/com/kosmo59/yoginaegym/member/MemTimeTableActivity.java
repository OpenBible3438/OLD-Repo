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

public class MemTimeTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_time_table);

        MemberTimeTablePagerAdapter memberTimeTablePagerAdapter = new MemberTimeTablePagerAdapter(getSupportFragmentManager());
        ViewPager vp_memTimeTable = findViewById(R.id.vp_memTimeTable);
        TabLayout tl_memTimeTable = findViewById(R.id.tl_memTimeTableTab);
        vp_memTimeTable.setAdapter(memberTimeTablePagerAdapter);
        tl_memTimeTable.setupWithViewPager(vp_memTimeTable);
    }

    private class MemberTimeTablePagerAdapter extends FragmentPagerAdapter{

        public MemberTimeTablePagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new MemTimeTableAFragment();
                case 1:
                    return new MemTimeTableBFragment();
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
                    return "주별보기";
            }
            return null;
        }
    }
}
