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
import com.kosmo59.yoginaegym.common.AppVO;
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
    private Spinner spn_reviewkind;
    private String rev_kind = null;
    private String className = "";
    private Button btn_myReviewReg_ins;
    private SimpleDateFormat simpleDateFormat = null;
    private EditText et_revkind, et_revcont, et_revdate, et_revtime, et_revstar;
    Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
    ArrayList<String> classList;
    ArrayList<Integer> payNo;
    private long pay_no = 0;
    private List<Map<String, Object>> sclassList = null;

    public MyReviewRegDialog(Context context) {
        this.context = context;
    }

    public void openMyReviewReg() {
        AppVO vo = (AppVO)context.getApplicationContext();
        Log.i("vo : ",vo+"");
        int memno = vo.getMem_no();
        Log.i("memno : ",memno+"");
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
            String url = "android/jsonRevClsList.gym";
            Map<String, Object> pMap = new HashMap<>();
            pMap.put("mem_no",memno);
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(url, pMap.toString()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("result : ",result+"");
        try {
            JSONArray jsonArray = new JSONArray(result);
            //sclassList = new ArrayList<>();
            classList = new ArrayList<String>();
            payNo = new ArrayList<Integer>();
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                classList.add(jsonObject.getString("CLS_NAME"));
                payNo.add(jsonObject.getInt("PAY_NO"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Gson g = new Gson();
//        sclassList = (List<Map<String, Object>>)g.fromJson(result, listType);
//        classList = new ArrayList<String>();
//        payNo = new ArrayList<Integer>();
//        for (int i=0; i<sclassList.size(); i++) {
//            classList.add(sclassList.get(i).get("CLS_NAME").toString());
//            payNo.add((int)sclassList.get(i).get("PAY_NO"));
//        }

//        final ArrayList arrayList = new ArrayList<String>();
//        arrayList.add("수업테스트0");
//        arrayList.add("수업테스트1");
//        arrayList.add("수업테스트2");
//        arrayList.add("수업테스트3");
        Toast.makeText(dlg.getContext(), memno+""+classList.toString(), Toast.LENGTH_SHORT).show();
        /* */
        spn_tchClassSpinner =
                dlg.findViewById(R.id.spn_tchClassSpinner);

        spn_reviewkind =
                dlg.findViewById(R.id.spn_reviewkind);

        /* 수업 이름 Spinner */
        ArrayAdapter<String> selectClassAdapter = new ArrayAdapter<>(context,R.layout.support_simple_spinner_dropdown_item,classList);
        //selectClassAdapter = ArrayAdapter.createFromResource(context,R.layout.support_simple_spinner_dropdown_item,arrayList);
        spn_tchClassSpinner.setAdapter(selectClassAdapter);
        spn_tchClassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  /*className = spn_tchClassSpinner.getItemAtPosition(position).toString();  */
                Toast.makeText(context, classList.get(position), Toast.LENGTH_SHORT).show();
                Log.i("payNo.get(position) : ",payNo.get(position)+"");
                pay_no = payNo.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /* 후기 종휴 Spinner */
        ArrayAdapter Adapter = ArrayAdapter.createFromResource(context, R.array.selectReview, android.R.layout.simple_spinner_dropdown_item);
        spn_reviewkind.setAdapter(Adapter);
        spn_reviewkind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                className = spn_reviewkind.getItemAtPosition(position).toString();
                /*Toast.makeText(context, className+"선택", Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        final Spinner spn_type = dlg.findViewById(R.id.spn_reviewkind);
        spn_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rev_kind = spn_type.getItemAtPosition(position).toString();
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
                //Toast.makeText(context, "등록 클릭 : "+pay_no, Toast.LENGTH_SHORT).show();
                Button button1 = dlg.findViewById(R.id.btn_myReviewReg_ins);

                EditText et_reg = dlg.findViewById(R.id.review_reg);
                EditText et_star = dlg.findViewById(R.id.rev_star);
                //Toast.makeText(context, "등록 클릭 : "+textContent, Toast.LENGTH_SHORT).show();

                String rev_cont = et_reg.getText().toString();
                String rev_star = et_star.getText().toString();

                Map<String,Object> pMap = new HashMap<>();
                pMap.put("pay_no",pay_no);
                pMap.put("rev_kind",rev_kind);
                pMap.put("rev_cont",rev_cont);
                pMap.put("rev_star",rev_star);
                pMap.put("cud","ins");
                Log.i("후기 등록버튼을 누르면 :",pMap.toString());
                //Toast.makeText(context, pMap.toString(), Toast.LENGTH_LONG).show();
                String send = "android/memReviewIns.gym";
                String result = null;
                try {
                    TomcatSend tomcatSend = new TomcatSend();
                    result = tomcatSend.execute(send, pMap.toString()).get();
                }catch(Exception e){
                    Log.i("Review Log", "Exception : " + e.toString());
                }
                if("1".equals(result)) {
                    Toast.makeText(context, "등록 되었습니다.", Toast.LENGTH_LONG).show();
                    dlg.hide();
                } else if("0".equals(result)) {
                    Toast.makeText(context, "등록 실패.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
