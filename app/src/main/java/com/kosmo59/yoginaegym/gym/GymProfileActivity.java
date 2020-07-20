package com.kosmo59.yoginaegym.gym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;
import com.kosmo59.yoginaegym.member.MemChatListActivity;
import com.kosmo59.yoginaegym.member.MemContentActivity;
import com.kosmo59.yoginaegym.member.MemMainActivity;

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
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymProfileActivity extends AppCompatActivity{
    ImageView iv_memQr = null;
    TextView tv_memQrName=null;
    TextView tv_memQrNumber=null;
    int gym_no = 0;
    AppVO vo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_profile);

        vo = (AppVO) getApplicationContext();
        gym_no = vo.gym_no;
//        Toast.makeText(getApplicationContext(), gym_no+"번 매장 클릭", Toast.LENGTH_SHORT).show();

        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonGymProfile.gym";
        Map<String, Object> pMap = new HashMap<>();
        List<Map<String, Object>> gymProf = new ArrayList<>();
        pMap.put("gym_no", gym_no);/////////////바꿀 코드
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i("테스트", "pMap : " + pMap);
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);

//        if(result != null){
//            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(), "문제 발생.", Toast.LENGTH_LONG).show();
//        }
        Gson g = new Gson();
        gymProf = (List<Map<String, Object>>)g.fromJson(result, listType);
        ////////////////////////////////////DB 연동 끝////////////////////////////////////
        Log.i("테스트", "gymMap : " + gymProf);

        TextView tv_memProName = (TextView) findViewById(R.id.tv_memProName);
        TextView tv_memProTel = (TextView) findViewById(R.id.tv_memProTel);
        TextView tv_memProAddr = (TextView) findViewById(R.id.tv_memProAddr);

        tv_memProName.setText(gymProf.get(0).get("GYM_NAME").toString());
        tv_memProTel.setText(gymProf.get(0).get("GYM_TEL").toString());
        tv_memProAddr.setText(gymProf.get(0).get("GYM_ADDR").toString());

        //프래그먼트와 ViewPager 연결하기
        GymPagerAdapter gymPagerAdapter = new GymPagerAdapter(getSupportFragmentManager());
        ViewPager vp_gymProfile = findViewById(R.id.vp_gymProfile);
        vp_gymProfile.setAdapter(gymPagerAdapter);
        //ViewPager를 TabLayout에 연결하기
        TabLayout tl_gymProfile = findViewById(R.id.tl_gymProfile);
        tl_gymProfile.setupWithViewPager(vp_gymProfile);

        /* 하단바 추가 */
        BottomNavigationView bottom = findViewById(R.id.bottom_nav);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        //GymSearchActivity를 죽이고 MemMain으로 이동해야됨.
                        GymSearchActivity gymSearchActivity = (GymSearchActivity)GymSearchActivity.gymSearchActivity;
                        gymSearchActivity.finish();
                        GymProfileActivity.super.onBackPressed();
                        break;
                    case R.id.bot_nav_qr:
                        //다이얼로그 초기화
                        final Dialog dlg = new Dialog(GymProfileActivity.this);
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dlg.setContentView(R.layout.dialog_mem_qr);
                        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
                        //QR 코드 생성
                        String data = vo.getMemberId(); //mem_id로 QR코드 생성
                        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                        try {
                            BitMatrix bitMatrix = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 300,300);
                            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                            Log.i("QR Make", "생성된 QR Bitmap : "+bitmap.toString());
                            iv_memQr = dlg.findViewById(R.id.iv_memQr);
                            tv_memQrName = dlg.findViewById(R.id.tv_memQrName);
                            iv_memQr.setImageBitmap(bitmap); //만들어진 QR코드 붙이기
                            tv_memQrName.setText(vo.getMemberName()+" 회원님");
                            tv_memQrNumber = dlg.findViewById(R.id.tv_memQrNumber);
                            tv_memQrNumber.setText(vo.getMem_no()+"");
                        }catch (Exception e){
                            Log.i("QR Make", e.toString());
                        }
                        dlg.show();
                        break;
                    case R.id.bot_nav_cont:
                        Intent intent_cont = new Intent(GymProfileActivity.this, MemContentActivity.class);
                        startActivity(intent_cont);
                        break;
                    case R.id.bot_nav_msg:
                        Intent intent_msg = new Intent(GymProfileActivity.this, MemChatListActivity.class);
                        startActivity(intent_msg);
                        break;

                }
                return false;
            }
        });
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
