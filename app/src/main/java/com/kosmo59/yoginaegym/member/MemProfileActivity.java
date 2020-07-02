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

public class MemProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_profile);

        //프래그먼트와 ViewPager 연결하기
        MemberPagerAdapter memberPagerAdapter = new MemberPagerAdapter(getSupportFragmentManager());
        ViewPager vp_memProfile = findViewById(R.id.vp_memProfile);
        //ViewPager를 TabLayout에 연결하기
        TabLayout tl_memProfile = findViewById(R.id.tl_memProfile);
        vp_memProfile.setAdapter(memberPagerAdapter);
        tl_memProfile.setupWithViewPager(vp_memProfile);
    }

    private class MemberPagerAdapter extends FragmentPagerAdapter{
        public MemberPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) { /* 각 페이지에 표시할 프래그먼트 지정 */
            switch (position){
                case 0:
                    return new InbodyFragment();
                case 1:
                    return new PayListFragment();
                case 2:
                    return new MyReviewFragment();
                case 3:
                    return new BookmarkFragment();
            }
            return null;
        }

        @Override
        public int getCount() {/* 페이지 수 지정 */
            /* 인바디, 결제내역, 내 리뷰, 즐겨찾기 => 4장 */
            return 4;
        }
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "인바디";
                case 1:
                    return "결제내역";
                case 2:
                    return "내 후기";
                case 3:
                    return "즐겨찾기";
            }
            return null;
        }
    }
}
