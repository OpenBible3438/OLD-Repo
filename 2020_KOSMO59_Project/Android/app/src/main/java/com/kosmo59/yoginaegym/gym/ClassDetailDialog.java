package com.kosmo59.yoginaegym.gym;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassDetailDialog {
    private Context context;
    private ImageButton icon_close;
    private int cho_cls = 0;

    List<Map<String, Object>> clsDtl;
    public ClassDetailDialog(Context context, int cho_cls) {
        this.context = context;
        this.cho_cls = cho_cls;
    }

    public void openClassDetailDialog() {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_class_detail);

        //---다이얼로그 화면 사이즈 조정 시작
        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
        //---다이얼로그 화면 사이즈 조정 끝

        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonClsDtl.gym";
        String nowCls = null;
        Map<String, Object> clsMap = new HashMap<>();
        clsMap.put("cls_no", cho_cls);
        nowCls = clsMap.toString();
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i("테스트", "nowCls : " + nowCls);
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, nowCls).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);
//
//        if(result != null){
//            Toast.makeText(container.getContext(), result, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(container.getContext(), "문제 발생.", Toast.LENGTH_LONG).show();
//        }
        Gson g = new Gson();
        clsDtl = (List<Map<String, Object>>)g.fromJson(result, listType);
        Log.i("테스트", "clsDtl : " + clsDtl);
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        TextView cls_name = dlg.findViewById(R.id.cls_name);
        TextView tch_name = dlg.findViewById(R.id.tch_name);
        TextView cls_type = dlg.findViewById(R.id.cls_type);
        TextView cls_kind = dlg.findViewById(R.id.cls_kind);
        TextView cls_s_date = dlg.findViewById(R.id.cls_s_date);
        TextView cls_e_date = dlg.findViewById(R.id.cls_e_date);
        TextView cls_s_time = dlg.findViewById(R.id.cls_s_time);
        TextView cls_e_time = dlg.findViewById(R.id.cls_e_time);
        TextView cls_day = dlg.findViewById(R.id.cls_day);
        TextView cls_cnt = dlg.findViewById(R.id.cls_cnt);
        TextView cls_days = dlg.findViewById(R.id.cls_days);
        TextView cls_info = dlg.findViewById(R.id.cls_info);
        TextView cls_price = dlg.findViewById(R.id.cls_price);
        TextView cls_state = dlg.findViewById(R.id.cls_state);

        cls_name.setText(clsDtl.get(0).get("CLS_NAME").toString());
        tch_name.setText(clsDtl.get(0).get("TCH_NAME").toString());
        cls_type.setText(clsDtl.get(0).get("TYPE_NAME").toString());
        cls_kind.setText(clsDtl.get(0).get("CLS_KIND").toString());
        cls_s_date.setText(clsDtl.get(0).get("CLS_S_DATE").toString());
        cls_e_date.setText(clsDtl.get(0).get("CLS_E_DATE").toString());
        cls_s_time.setText(clsDtl.get(0).get("CLS_STIME").toString());
        cls_e_time.setText(clsDtl.get(0).get("CLS_ETIME").toString());
        cls_day.setText(clsDtl.get(0).get("CLS_DAY").toString());
        cls_cnt.setText((clsDtl.get(0).get("CLS_CNT").toString()).split("\\.")[0]);
        cls_days.setText((clsDtl.get(0).get("CLS_DAYS").toString()).split("\\.")[0]);
        cls_info.setText(clsDtl.get(0).get("CLS_INFO").toString());
        cls_price.setText((clsDtl.get(0).get("CLS_PRICE").toString()).split("\\.")[0]);
        cls_state.setText(clsDtl.get(0).get("CLS_STATE").toString());

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        icon_close = dlg.findViewById(R.id.icon_close);
        icon_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.hide();
            }
        });
    }
}
