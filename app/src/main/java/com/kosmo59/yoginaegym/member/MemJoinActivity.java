package com.kosmo59.yoginaegym.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.kosmo59.yoginaegym.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.kosmo59.yoginaegym.common.TomcatSend;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class MemJoinActivity extends AppCompatActivity {

    private static final int SEARCH_ADDRESS_ACTIVITY = 10000;

    private EditText et_memId, et_address, et_name, et_nickname, et_memTel, et_addrDtl, et_memPw, et_memPwConf;
    private Button btn_nameCheck, btn_join, btn_joinCancel, btn_nicCheck, btn_memPickProfile, btn_searchAddr;
    private TextView tv_joinPwConf;
    private MaterialButtonToggleGroup toggle_gender;
    private MaterialButton btn_man, btn_woman;

    //프로필 이미지 관련 변수
    private FirebaseStorage storage;
    private StorageReference storageRef;
    private final String JOIN_LOG = "MemJoinActivity";
    private final int GET_PROFILE_IMAGE = 20000;
    private ImageView iv_joinImage;
    private Bitmap bitmap;
    private BitmapDrawable bitmapDrawable = null;
    private SwitchMaterial joinAdmit;
    String gender = "";
    private byte[] img=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_join);

        //아이디
        et_memId = findViewById(R.id.et_memId);
        btn_nameCheck = findViewById(R.id.btn_nameCheck);

        //비밀번호
        et_memPw = findViewById(R.id.et_memPw);
        et_memPwConf = findViewById(R.id.et_memPwConf);
        et_memPwConf.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (et_memPw.getText().toString().length() > 0){
                    if(et_memPw.getText().toString().equals(et_memPwConf.getText().toString())){
                        tv_joinPwConf = findViewById(R.id.tv_joinPwConf);
                        tv_joinPwConf.setText("비밀번호가 일치합니다.");
                        tv_joinPwConf.setTextColor(Color.BLUE);
                    } else {
                        tv_joinPwConf = findViewById(R.id.tv_joinPwConf);
                        tv_joinPwConf.setText("비밀번호가 일치하지 않습니다.");
                        tv_joinPwConf.setTextColor(Color.RED);
                    }
                }
                return true;
            }
        });

        //이름
        et_name = findViewById(R.id.et_name);

        //닉네임
        et_nickname = findViewById(R.id.et_nickname);
        btn_nicCheck = findViewById(R.id.btn_nicCheck);

        //프로필 사진
        iv_joinImage = findViewById(R.id.iv_joinImage);

        //전화번호
        et_memTel = findViewById(R.id.et_memTel);

        //주소
        et_address = findViewById(R.id.et_address);
        btn_searchAddr = findViewById(R.id.btn_searchAddr);
        btn_searchAddr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MemJoinActivity.this, "클릭클릭", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MemJoinActivity.this, MemAddressActivity.class);
                startActivityForResult(intent, SEARCH_ADDRESS_ACTIVITY);
            }
        });

        //상세주소
        et_addrDtl = findViewById(R.id.et_addrDtl);

        //성별
        toggle_gender = findViewById(R.id.toggle_gender);
        toggle_gender.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                //btn_man = toggle_gender.findViewById(R.id.btn_man);
                MaterialButton btn_woman = toggle_gender.findViewById(R.id.btn_woman);
                MaterialButton btn_man = toggle_gender.findViewById(R.id.btn_man);
                gender = "";
                if((checkedId == R.id.btn_man && isChecked) || !btn_woman.isChecked() ){
                    gender = "남성";
                }else if((checkedId == R.id.btn_woman && isChecked) || !btn_man.isChecked()) {
                    gender = "여성";
                }
            }
        });

        //생년월일
        et_birth = findViewById(R.id.et_birth);
        et_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다이얼로그 떴을 때 현재 날짜로 띄우기
                new DatePickerDialog(MemJoinActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog, datePicker
                        , calendar.get(Calendar.YEAR)
                        , calendar.get(Calendar.MONTH)
                        , calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //제공동의
        joinAdmit = findViewById(R.id.joinAdmit);

        //가입하기
        btn_join = findViewById(R.id.btn_join);

        //취소하기
        btn_joinCancel = findViewById(R.id.btn_joinCancel);
        btn_joinCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //뒤로가기. => MemLoginActivity이동
                //intent 사용하지 않음
                Toast.makeText(MemJoinActivity.this, "가입 취소되었습니다.", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }

    /* 생년월일 */
    private EditText et_birth;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateEt_birth();
        }
    };

    /*et_birth에 다이얼로그로 설정한 날짜로 바꿔주기*/
    private void updateEt_birth() {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.KOREA);
        et_birth.setText(sdf.format(calendar.getTime()));
    }

    public void memProImgAdd(View view) {
        //사진 선택 함수
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, GET_PROFILE_IMAGE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch (requestCode) {
            /* SEARCH_ADDRESS_ACTIVITY 일 땐 주소찾기 */
            case SEARCH_ADDRESS_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    String data = intent.getExtras().getString("data");
                    if (data != null) {
                        /* MemAddressActivity의 WebView에서 주소를 받아와서 EditText에 찍어줌 */
                        et_address.setText(data);
                    }
                }
                break;
            /* GET_PROFILE_IMAGE 일 땐 이미지 불러오기 */
            case GET_PROFILE_IMAGE:
                if (requestCode == GET_PROFILE_IMAGE && resultCode == RESULT_OK && intent != null && intent.getData() != null) {
                    Uri selectedImageUri = intent.getData();
                    iv_joinImage.setImageURI(selectedImageUri);
                    //이미지뷰의 이미지를 Bitmap으로 저장하기
                    bitmapDrawable = (BitmapDrawable) iv_joinImage.getDrawable();
                    bitmap = bitmapDrawable.getBitmap();
                    //byte[]에 담기
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    img = baos.toByteArray();
                }
                break;
        }
    }

    /* 가입하기 버튼 클릭 ! */
    public void joinClick(View view) {
        if (!joinAdmit.isChecked()) {
            //정보제공 체크되어있지 않을 경우
            Toast.makeText(MemJoinActivity.this, "정보제공 동의해주세요!", Toast.LENGTH_SHORT).show();
        } else { //정보제공 체크했을 경우 => 회원가입
            final String memId = et_memId.getText().toString();
            final String memPw = et_memPw.getText().toString();
            final String memName = et_name.getText().toString();
            final String memNickname = et_nickname.getText().toString();
            final String memTel = et_memTel.getText().toString();
            final String[] memAdd = et_address.getText().toString().split(",");
            //받아온 주소랑 우편번호 나누기
            String memAddr = memAdd[0];
            int memZipcode = Integer.parseInt(memAdd[1]);
            final String memAddDtl = et_addrDtl.getText().toString();
            final String memGender = gender;
            final String memBirth = et_birth.getText().toString();

            String send = "android/memberJoin.gym?cud=ins";
            //List<Map<String, String>> joinList = null;
            Map<String, Object> pMap = new HashMap<>();
            pMap.put("mem_id", memId);
            pMap.put("mem_pw", memPw);
            pMap.put("mem_name", memName);
            pMap.put("mem_nickname", memNickname);
            pMap.put("mem_tel", memTel);
            pMap.put("mem_addr", memAddr);
            pMap.put("mem_zipcode", memZipcode);
            pMap.put("mem_addr_dtl", memAddDtl);
            pMap.put("mem_gender", memGender);
            pMap.put("mem_birth", memBirth);
            pMap.put("img", img);
            pMap.put("filename", memId+"img");

            String result = null;
            try {
                TomcatSend tomcatSend = new TomcatSend();
                result = tomcatSend.execute(send,pMap.toString()).get();
            } catch (Exception e){
                Log.i(JOIN_LOG, "Exception : "+e.toString());
            }
            Log.i(JOIN_LOG, "톰캣 서버에서 읽어온 정보 : "+result);

            if(result != null){
                Toast.makeText(MemJoinActivity.this, "회원가입 성공! 로그인해주세요.", Toast.LENGTH_SHORT).show();
                MemJoinActivity.super.onBackPressed();
            } else {
                Toast.makeText(MemJoinActivity.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                MemJoinActivity.super.onBackPressed();
            }

        }
    }
}