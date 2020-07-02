package com.kosmo59.yoginaegym.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kosmo59.yoginaegym.R;
import android.os.Bundle;

public class TchManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_manage);

        //프래그먼트와 ViewPager 연결하기
        TchManagePagerAdapter tchManagePagerAdapter = new TchManagePagerAdapter(getSupportFragmentManager());
        ViewPager vp_tchManage = findViewById(R.id.vp_tchManage);
        //ViewPager를 TabLayout에 연결하기
        TabLayout tl_tchManage = findViewById(R.id.tl_tchManage);
        vp_tchManage.setAdapter(tchManagePagerAdapter);
        tl_tchManage.setupWithViewPager(vp_tchManage);
    }

    private class TchManagePagerAdapter extends FragmentPagerAdapter{
        public TchManagePagerAdapter(FragmentManager supportFragmentManager){
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {/* 각 페이지에 표시할 프래그먼트 지정 */
            switch (position){
                case 0:
                    return new TchClassFragment();
                case 1:
                    return new TchInbodyFragment();
                case 2:
                    return new MemoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            /* 페이지 수. 수업, 인바디, 메모 => 3장 */
            return 3;
        }
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "내 수업";
                case 1:
                    return "인바디";
                case 2:
                    return "메모";
            }
            return null;
        }
    }
}
