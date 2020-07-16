package com.kosmo59.yoginaegym.member;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;


public class MyreviewRegDialog {
    private Context context;
    private Spinner reviewInsSpinner;
    private String className = "";
    private Button btn_revIns1;
    private SimpleDateFormat simpleDateFormat = null;
    private EditText et_revkind, et_revcont, et_revdate, et_revtime, et_revstar;


    public MyreviewRegDialog(Context context) {
        this.context = context;
    }

    public void openMyReviewReg() {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_my_review_reg);

        // 커스텀 다이얼로그 사이즈 조정
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dlg.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        Window window = dlg.getWindow();
        window.setAttributes(lp);


        // 커스텀 다이얼로그를 노출한다.
        dlg.show();
        reviewInsSpinner = dlg.findViewById(R.id.reviewInsSpinner);

        ArrayAdapter selectClassAdapter = ArrayAdapter.createFromResource(context, R.array.selectClass, android.R.layout.simple_spinner_dropdown_item);
        reviewInsSpinner.setAdapter(selectClassAdapter);
        reviewInsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                className = reviewInsSpinner.getItemAtPosition(position).toString();
                /*Toast.makeText(context, className+"선택", Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /* 등록 버튼 시작 */
        Button button = dlg.findViewById(R.id.btn_revIns1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    void show() {
        Log.i("테스트", "show()");
//        Toast.makeText(context.getApplicationContext(),"show()", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("등록하시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context.getApplicationContext(),"등록되었습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context.getApplicationContext(),"취소되었습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();

//                        final String rev_kind = et_revkind.getText().toString();
//                        final String rev_cont = et_revcont.getText().toString();
//                        final String rev_star = et_revstar.getText().toString();
//
//                        /*map 만들기*/
//                        Map<String, Object> pMap = new HashMap<>();
//                        pMap.put("rev_kind", rev_kind);
//                        pMap.put("rev_cont", rev_cont);
//                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                        String date = simpleDateFormat.format(System.currentTimeMillis());
//                        pMap.put("rev_date", date);
//                        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//                        String time = simpleDateFormat.format(System.currentTimeMillis());
//                        pMap.put("rev_time", time);
//                        pMap.put("rev_star", rev_star);
//
//
//                        String send = "android/getGymReviewIns.gym?cud=ins";
//                        String result = null;
//                        try {
//                            TomcatSend tomcatSend = new TomcatSend();
//                            result = tomcatSend.execute(send, pMap.toString()).get();
//                        } catch (Exception e) {
//                            Log.i("Review Log", "Exception : " + e.toString());
//                        }
//                        Log.i("Review Log", "톰캣 서버에서 읽어온 정보 : " + result);
//
//                        /*if(result != null){
//                            Toast.makeText(MyreviewRegDialog.this, "등록되었습니다.", Toast.LENGTH_SHORT).show();
//                            MyreviewRegDialog.super.onBackPressed();
//                        } else {
//                            Toast.makeText(MyreviewRegDialog.this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
//                            MyreviewRegDialog.super.onBackPressed();
//                        }*/
//                        /* */
//                        if (result != null) {
//                            Toast.makeText(context, "등록되었습니다.", Toast.LENGTH_SHORT).show();
//                            ((Activity) context).onBackPressed();
//                        } else {
//                            Toast.makeText(context, "취소되었습니다", Toast.LENGTH_SHORT).show();
//                            ((Activity) context).onBackPressed();
//                        }

//                    }
//                });

    }
}

