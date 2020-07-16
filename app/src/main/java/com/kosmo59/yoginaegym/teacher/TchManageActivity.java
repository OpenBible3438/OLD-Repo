package com.kosmo59.yoginaegym.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.gym.GymNoticeFragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class TchManageActivity extends AppCompatActivity {

    AppVO vo = null;
    ImageView iv_memQr = null;
    TextView tv_memQrName=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_manage);

        vo = (AppVO) getApplicationContext();

        //프래그먼트와 ViewPager 연결하기
        TchManagePagerAdapter tchManagePagerAdapter = new TchManagePagerAdapter(getSupportFragmentManager());
        ViewPager vp_tchManage = findViewById(R.id.vp_tchManage);
        //ViewPager를 TabLayout에 연결하기
        TabLayout tl_tchManage = findViewById(R.id.tl_tchManage);
        vp_tchManage.setAdapter(tchManagePagerAdapter);
        tl_tchManage.setupWithViewPager(vp_tchManage);

        /* 하단바 */
        BottomNavigationView bottom = findViewById(R.id.bottom_nav);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        TchManageActivity.super.onBackPressed();
                        break;
                    case R.id.bot_nav_qr:
                        //다이얼로그 초기화
                        final Dialog dlg = new Dialog(TchManageActivity.this);
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
                        Intent intent_cont = new Intent(TchManageActivity.this, TchContentActivity.class);
                        startActivity(intent_cont);
                        TchManageActivity.this.finish();
                        break;
                    case R.id.bot_nav_msg:
                        Intent intent_msg = new Intent(TchManageActivity.this, TchChatListActivity.class);
                        startActivity(intent_msg);
                        TchManageActivity.this.finish();
                        break;

                }
                return false;
            }
        });
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
                    return new GymNoticeFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            /* 페이지 수. 수업, 인바디, 메모 => 3장 */
            return 2;
        }
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "수업 & 수강생 관리";
                case 1:
                    return "공지사항";

            }
            return null;
        }
    }
}
