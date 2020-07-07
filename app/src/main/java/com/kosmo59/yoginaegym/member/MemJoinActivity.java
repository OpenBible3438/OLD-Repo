package com.kosmo59.yoginaegym.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.kosmo59.yoginaegym.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MemJoinActivity extends AppCompatActivity {

    private static final int SEARCH_ADDRESS_ACTIVITY = 10000;

    private EditText et_memId, et_address, et_name, et_nickname, et_memTel, et_addrDtl, et_memPw;
    private Button btn_nameCheck, btn_join, btn_joinCancel, btn_nicCheck, btn_man, btn_woman, btn_memPickProfile;

    //프로필 이미지 관련 변수
    private FirebaseStorage storage;
    private StorageReference storageRef;
    private final String HTTP_LOG_TAG = "HttpUpload";
    private final int GET_PROFILE_IMAGE = 20000;
    private ImageView iv_joinImage;
    private String img_path = null;
    private String serverUrl = "http://192.168.0.27:5000/android/joinProfileImage.jsp";
    private Bitmap bitmap;
    private BitmapDrawable bitmapDrawable = null;
    private SwitchMaterial joinAdmit;
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_join);

        //아이디
        et_memId = findViewById(R.id.et_memId);
        btn_nameCheck = findViewById(R.id.btn_nameCheck);

        //비밀번호
        et_memPw = findViewById(R.id.et_memPw);

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

        //상세주소
        et_addrDtl = findViewById(R.id.et_addrDtl);

        //성별
        btn_man = findViewById(R.id.btn_man);
        btn_woman = findViewById(R.id.btn_woman);
        if (btn_man.isClickable()) {
            gender = "남자";
        } else if (btn_woman.isClickable()) {
            gender = "여자";
        }

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

    public void searchAdd(View view) {
        /*
        주소 검색을 클릭하면 WebView 연결.
         */
        Intent intent = new Intent(MemJoinActivity.this, MemAddressActivity.class);
        startActivityForResult(intent, SEARCH_ADDRESS_ACTIVITY);
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
                    //bitmapDrawable = (BitmapDrawable) iv_joinImage.getDrawable();
                    //bitmap = bitmapDrawable.getBitmap();
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
            final String memAdd = et_address.getText().toString();
            final String memAddDtl = et_addrDtl.getText().toString();
            final String memGender = gender;
            final String memBirth = et_birth.getText().toString();

            //사진 전송 firebase storage에 저장
            storage = FirebaseStorage.getInstance();
            storageRef = storage.getReference();
            //경로 설정
            StorageReference memberRef = storageRef.child("Member_Profile_Image");
            //ImageView 데이터를 byte[]에 담기
            BitmapDrawable bitmapDrawable = (BitmapDrawable) iv_joinImage.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] data = baos.toByteArray();

            //입력한 id로 이미지 이름 결정
            UploadTask uploadTask = memberRef.child(et_memId.getText()+"_proImg").putBytes(data);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    //업로드 실패했을 때
                    Log.i("ImageUpload","업로드에 실패했습니다.");
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //업로스 성공했을 때
                    Log.i("ImageUpload", "업로드 성공~!");
                }
            });

            Toast.makeText(MemJoinActivity.this, "회원가입 완료! 로그인해주세요.", Toast.LENGTH_SHORT).show();
            MemJoinActivity.super.onBackPressed();
        }
    }
}