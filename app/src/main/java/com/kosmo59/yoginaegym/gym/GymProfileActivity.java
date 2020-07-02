package com.kosmo59.yoginaegym.gym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kosmo59.yoginaegym.R;
import android.os.Bundle;

public class GymProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_profile);

        //프래그먼트와 ViewPager 연결하기
        GymPagerAdapter gymPagerAdapter = new GymPagerAdapter(getSupportFragmentManager());
        ViewPager vp_gymProfile = findViewById(R.id.vp_gymProfile);
        vp_gymProfile.setAdapter(gymPagerAdapter);
        //ViewPager를 TabLayout에 연결하기
        TabLayout tl_gymProfile = findViewById(R.id.tl_gymProfile);
        tl_gymProfile.setupWithViewPager(vp_gymProfile);
    }

    private class GymPagerAdapter extends FragmentPagerAdapter{
        public GymPagerAdapter(FragmentManager supportFragmentManager){
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {/* 각 페이지에 표시할 프래그먼트 지정 */
            switch (position){
                case 0:
                    return new PRImageFragment();
                case 1:
                    return new GymggunFragment();
                case 2:
                    return new ClassFragment();
                case 3:
                    return new GymReviewFragment();
            }
            return null;
        }

        @Override
        public int getCount() { /* 페이지 수 지정 */
            /* 홍보, 강사진, 수업, 후기 => 4장 */
            return 4;
        }

        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "홍보";
                case 1:
                    return "강사진";
                case 2:
                    return "수업";
                case 3:
                    return "매장후기";
            }
            return null;
        }
    }
}
