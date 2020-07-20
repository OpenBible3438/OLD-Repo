package com.kosmo59.yoginaegym.member;

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

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MemProfileActivity extends AppCompatActivity {

    private AppVO vo = null;
    ImageView iv_memQr = null;
    TextView tv_memQrName=null;
    TextView tv_memQrNumber=null;
    List<Map<String, Object>> memProfList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_profile);
        vo = (AppVO) getApplicationContext();

        //DB 연동 시작
        Log.i("MemProfActivity", "호출 성공 DB 시작");
        String result = null;
        String reqUrl = "android/jsonMemberProfile.gym";
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("mem_no", vo.getMem_no());
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        try{
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, pMap.toString()).get();
        }catch (Exception e){
            Log.i("MemProfActivity", "Exception : "+e.toString());
        }
        Log.i("MemProfActivity", "톰캣서버에서 읽어온 정보 : "+result);
        Gson g = new Gson();
        memProfList = (List<Map<String, Object>>)g.fromJson(result, listType);

        CircleImageView iv_memProImg = findViewById(R.id.iv_memProImg);
        TextView tv_memProName = findViewById(R.id.tv_memProName);
        TextView tv_memProTel = findViewById(R.id.tv_memProTel);
        TextView tv_memProAddr = findViewById(R.id.tv_memProAddr);
        tv_memProName.setText(memProfList.get(0).get("MEM_NAME").toString());
        tv_memProTel.setText(memProfList.get(0).get("MEM_TEL").toString());
        tv_memProAddr.setText(memProfList.get(0).get("MEM_ADDR").toString());
        try {
            TomcatImg tomcatImg = new TomcatImg();
            String imsi = memProfList.get(0).get("FILE_SEQ").toString().substring(0, memProfList.get(0).get("FILE_SEQ").toString().length()-2);
            String bitImg = tomcatImg.execute(imsi).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            iv_memProImg.setImageBitmap(bitmap);
        }catch (Exception e){
            Log.i("MemProfActivity", "Exception : "+e.toString());
        }

        //프래그먼트와 ViewPager 연결하기
        MemberPagerAdapter memberPagerAdapter = new MemberPagerAdapter(getSupportFragmentManager());
        ViewPager vp_memProfile = findViewById(R.id.vp_memProfile);
        //ViewPager를 TabLayout에 연결하기
        TabLayout tl_memProfile = findViewById(R.id.tl_memProfile);
        vp_memProfile.setAdapter(memberPagerAdapter);
        tl_memProfile.setupWithViewPager(vp_memProfile);

        //하단바
        BottomNavigationView bottom = findViewById(R.id.bottom_nav);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        MemProfileActivity.super.onBackPressed();
                        break;
                    case R.id.bot_nav_qr:
                        //다이얼로그 초기화
                        final Dialog dlg = new Dialog(MemProfileActivity.this);
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
                        Intent intent_cont = new Intent(MemProfileActivity.this, MemContentActivity.class);
                        startActivity(intent_cont);
                        MemProfileActivity.this.finish();
                        break;
                    case R.id.bot_nav_msg:
                        Intent intent_msg = new Intent(MemProfileActivity.this, MemChatListActivity.class);
                        startActivity(intent_msg);
                        MemProfileActivity.this.finish();
                        break;

                }
                return false;
            }
        });
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
            }
            return null;
        }

        @Override
        public int getCount() {/* 페이지 수 지정 */
            /* 인바디, 결제내역, 내 리뷰, 즐겨찾기 => 4장 */
            return 3;
        }
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "인바디";
                case 1:
                    return "결제내역";
                case 2:
                    return "내 후기";
            }
            return null;
        }
    }
}
