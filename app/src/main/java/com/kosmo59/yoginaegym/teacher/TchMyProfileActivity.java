package com.kosmo59.yoginaegym.teacher;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatImg;
import com.kosmo59.yoginaegym.common.TomcatSend;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TchMyProfileActivity extends AppCompatActivity {
    private ImageButton icon_close;
    private Button btn_tchMyProfile_upd;
    private Button btn_tchMyProfile_img;
    TextView tch_name_dtl = null;
    TextView tch_id_dtl = null;
    TextView tch_gender_dtl = null;
    TextView tch_tel_dtl = null;
    TextView tch_career_dtl = null;
    TextView tch_intro_dtl = null;
    ImageView tch_img_dtl = null;
    List<Map<String, Object>> mList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_my_profile);

        icon_close = findViewById(R.id.icon_close);
        icon_close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"activity_tch_main으로 이동해주세요.", Toast.LENGTH_LONG).show();
                TchMyProfileActivity.super.onBackPressed();
            }
        });
        String result = null;
        String reqUrl = "android/jsonTeacherProf.gym";
        AppVO vo = (AppVO) getApplicationContext();
        String nowTch = null;
        Map<String, Object> tchMap = new HashMap<>();
        tchMap.put("tch_no", vo.getTchNum());
        nowTch = tchMap.toString();
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i("테스트", "nowTch : " + nowTch);
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, nowTch).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);
        Gson g = new Gson();
        mList = (List<Map<String, Object>>)g.fromJson(result, listType);
        tch_name_dtl = findViewById(R.id.tch_name);
        tch_id_dtl = findViewById(R.id.tch_id);
        tch_gender_dtl = findViewById(R.id.tch_gender);
        tch_tel_dtl = findViewById(R.id.tch_tel);
        tch_career_dtl = findViewById(R.id.tch_career);
        tch_intro_dtl = findViewById(R.id.tch_intro);
        tch_img_dtl = findViewById(R.id.tch_image);

        tch_name_dtl.setText(mList.get(0).get("TCH_NAME").toString());
        tch_id_dtl.setText(mList.get(0).get("TCH_ID").toString());
        tch_gender_dtl.setText(mList.get(0).get("TCH_GENDER").toString());
        tch_tel_dtl.setText(mList.get(0).get("TCH_TEL").toString());
        tch_career_dtl.setText(mList.get(0).get("TCH_CAREER").toString());
        tch_intro_dtl.setText(mList.get(0).get("TCH_INTRO").toString());
        Log.i("TchMyProfileActivity", "mList : " + mList);

        try {
            TomcatImg tomcatImg = new TomcatImg();
            String file_seq = ((mList.get(0).get("FILE_SEQ").toString()).split("\\."))[0];
            String bitImg = tomcatImg.execute(file_seq).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            tch_img_dtl.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        btn_tchMyProfile_upd = findViewById(R.id.btn_tchMyProfile_upd);
        btn_tchMyProfile_upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"수정 DB연동 해주세요.", Toast.LENGTH_LONG).show();
            }
        });


        btn_tchMyProfile_img = findViewById(R.id.btn_tchMyProfile_img);
        btn_tchMyProfile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"이미지 찾기 해주세요.", Toast.LENGTH_LONG).show();
            }
        });
 */
    }
}
