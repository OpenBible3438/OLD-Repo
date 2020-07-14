package com.kosmo59.yoginaegym.gym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GymProfileActivity extends AppCompatActivity{
    int gym_no = 0;
    AppVO vo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_profile);
        Intent intent = getIntent();

        vo = (AppVO) getApplicationContext();
        gym_no = vo.gym_no;
        Toast.makeText(getApplicationContext(), gym_no+"번 매장 클릭", Toast.LENGTH_SHORT).show();
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
                    return new PRImageFragment(GymProfileActivity.this);
                case 1:
                    return new GymggunFragment(GymProfileActivity.this);
                case 2:
                    return new ClassFragment(GymProfileActivity.this);
                case 3:
                    return new GymReviewFragment(GymProfileActivity.this);
                case 4:
                    return new GymNoticeFragment(GymProfileActivity.this);
            }
            return null;
        }

        @Override
        public int getCount() { /* 페이지 수 지정 */
            /* 홍보, 강사진, 수업, 후기 => 4장 */
            return 5;
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
                case 4:
                    return "공지사항";
            }
            return null;
        }
    }
}
