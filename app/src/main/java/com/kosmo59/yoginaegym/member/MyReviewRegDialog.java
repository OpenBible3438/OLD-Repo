package com.kosmo59.yoginaegym.member;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatSend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyReviewRegDialog {
    private Context context;
    private Spinner spn_tchClassSpinner;
    private String className = "";
    private Button btn_myReviewReg_ins;
    private SimpleDateFormat simpleDateFormat = null;
    private EditText et_revkind, et_revcont, et_revdate, et_revtime, et_revstar;
    Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
    ArrayList<String> classList;
    private List<Map<String, Object>> sclassList = null;

    public MyReviewRegDialog(Context context) {
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

        // 수업 정보를 가져옴...
        String result = null;
        try {
            String url = "android/getRevClassList.gym";
            Map<String, Object> pMap = new HashMap<>();
            pMap.put("mem_no","");
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(url, pMap.toString()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson g = new Gson();
        sclassList = (List<Map<String, Object>>)g.fromJson(result, listType);
        for (int i=0; i<sclassList.size(); i++) {
            classList.add(sclassList.get(i).get("CLS_NAME").toString());
        }
//        arrayList = new ArrayList<String>();
//        arrayList.add("수업테스트0");
//        arrayList.add("수업테스트1");
//        arrayList.add("수업테스트2");
//        arrayList.add("수업테스트3");
//        Toast.makeText(dlg.getContext(), arrayList.toString(), Toast.LENGTH_SHORT).show();
        /* */
        spn_tchClassSpinner =
                dlg.findViewById(R.id.spn_tchClassSpinner);

        ArrayAdapter<String> selectClassAdapter = new ArrayAdapter<>(context,R.layout.support_simple_spinner_dropdown_item,classList);
        //selectClassAdapter = ArrayAdapter.createFromResource(context,R.layout.support_simple_spinner_dropdown_item,arrayList);
        spn_tchClassSpinner.setAdapter(selectClassAdapter);
        spn_tchClassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  /*className = spn_tchClassSpinner.getItemAtPosition(position).toString();  */
                 Toast.makeText(context,classList. get(position) , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /* 등록 버튼 시작 */
        Button button = dlg.findViewById(R.id.btn_myReviewReg_ins);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "등록 클릭", Toast.LENGTH_SHORT).show();
                //show();
            }
        });
    }
    void show(){
        Toast.makeText(context.getApplicationContext(),"show()", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(context.getApplicationContext());
        final String revkind = et_revkind.getText().toString();
        final String revcont = et_revcont.getText().toString();
        final String revstar = et_revstar.getText().toString();
                /* map 만들기 */
        Map<String,Object> pMap = new HashMap<>();
        pMap.put("rev_kind",revkind);
        pMap.put("rev_cont",revcont);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(System.currentTimeMillis());
        pMap.put("rev_date", date);
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = simpleDateFormat.format(System.currentTimeMillis());
        pMap.put("rev_time", time);
        pMap.put("rev_star", revstar);

        // tomcat연동
//        String send = "android/getGymReviewIns.gym?cud=ins";
//        String result = null;
//        try {
//            TomcatSend tomcatSend = new TomcatSend();
//            result = tomcatSend.execute(send, pMap.toString()).get();
//        }catch(Exception e){
//            Log.i("Review Log", "Exception : " + e.toString());
//        }
//        Log.i("Review Log", "톰캣 서버에서 읽어온 정보 : " + result);


        builder.setMessage("등록하시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context.getApplicationContext(),"등록되었습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context.getApplicationContext(),"취소되었습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();

    }

}
