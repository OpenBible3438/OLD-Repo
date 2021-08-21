package com.kosmo59.yoginaegym.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatImg;
import com.kosmo59.yoginaegym.common.TomcatSend;
import com.kosmo59.yoginaegym.gym.GymNoticeFragment;
import com.kosmo59.yoginaegym.member.MemContentActivity;

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

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class TchManageActivity extends AppCompatActivity {

    ImageView iv_memQr = null;
    TextView tv_memQrName=null;
    TextView tv_memQrNumber=null;
    List<Map<String, Object>> tchProfList=null;
    AppVO vo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_manage);

        vo = (AppVO) getApplicationContext();

        //프로필 부분 DB 연동
        Log.i("TchManageActivity", "호출 성공 DB 시작");
        String result = null;
        String reqUrl = "android/jsonTeacherProf.gym";
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("tch_no", Integer.parseInt(vo.getTchNum()));
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        }catch (Exception e){
            Log.i("TchManageActivity", "Exception : "+e.toString());
        }
        Log.i("TchManageActivity", "톰캣서버에서 읽어온 정보 : "+result);
        Gson g = new Gson();
        tchProfList = (List<Map<String, Object>>)g.fromJson(result, listType);

        CircleImageView iv_memProImg = findViewById(R.id.iv_memProImg);
        TextView tv_tchManageName = findViewById(R.id.tv_tchManageName);
        TextView tv_tchManageTel = findViewById(R.id.tv_tchManageTel);

        tv_tchManageName.setText(tchProfList.get(0).get("TCH_NAME").toString());
        tv_tchManageTel.setText(tchProfList.get(0).get("TCH_TEL").toString());
        try {
            TomcatImg tomcatImg = new TomcatImg();
            String imsi = tchProfList.get(0).get("FILE_SEQ").toString().substring(0, tchProfList.get(0).get("FILE_SEQ").toString().length()-2);
            String bitImg = tomcatImg.execute(imsi).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            iv_memProImg.setImageBitmap(bitmap);
        }catch (Exception e){
            Log.i("TchManageActivity", "Exception : "+e.toString());
        }

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
                        String data = vo.getTchNum()+","+vo.getTchName(); //QR코드 data
                        try {
                            data = new String(data.getBytes("UTF-8"), "ISO-8859-1");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
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
                            tv_memQrNumber = dlg.findViewById(R.id.tv_memQrNumber);
                            tv_memQrNumber.setText(vo.getTchNum()+"");
                        }catch (Exception e){
                            Log.i("QR Make", e.toString());
                        }
                        dlg.show();
                        break;
                    case R.id.bot_nav_cont:
                        Intent intent_cont = new Intent(TchManageActivity.this, MemContentActivity.class);
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
            }
            return null;
        }

        @Override
        public int getCount() {
            /* 페이지 수. 수업, 인바디, 메모 => 3장 */
            return 1;
        }
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "수업 & 수강생 관리";

            }
            return null;
        }
    }
}
