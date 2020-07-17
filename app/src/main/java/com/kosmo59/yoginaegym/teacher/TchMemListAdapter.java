package com.kosmo59.yoginaegym.teacher;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TchMemListAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> mList = null;
    int resourceId;

    AppVO vo = null;

    int mem_no = 0;

    public TchMemListAdapter(@NonNull Context context, int resource, @NonNull List mList) {
        super(context, resource, mList);
        this.context = context;
        this.mList = mList;
        this.resourceId = resource;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return mList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);

        vo = (AppVO) context.getApplicationContext();

        Log.i("TchMemListAdapter", "호출");

        final TextView tch_memList_name = convertView.findViewById(R.id.tch_memList_name);
        TextView tch_memList_birth = convertView.findViewById(R.id.tch_memList_birth);
        TextView mem_memList_tel = convertView.findViewById(R.id.mem_memList_tel);

        tch_memList_name.setText(mList.get(position).get("MEM_NAME").toString());
        tch_memList_birth.setText(mList.get(position).get("MEM_BIRTH").toString());
        mem_memList_tel.setText(mList.get(position).get("MEM_TEL").toString());

        //mem_no 아무도 모르게 박아놓기
        final TextView hidden_mem_no = convertView.findViewById(R.id.hidden_mem_no);
        hidden_mem_no.setText(mList.get(position).get("MEM_NO").toString());
        String strMem_no = hidden_mem_no.getText().toString();
        String subMem_no = strMem_no.substring(0, strMem_no.length()-2);
        mem_no = Integer.parseInt(subMem_no);

        final TextView hidden_cls_no = convertView.findViewById(R.id.hidden_cls_no);
        //hidden_cls_no.setText(mList.get(position));

        //띄워지는 다이얼로그의 객체 id 설정
        CardView cv_memListDetail = convertView.findViewById(R.id.cv_memListDetail);
        CardView cv_memListMeno = convertView.findViewById(R.id.cv_memListMeno);
        cv_memListDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, tch_memList_name.getText().toString()+"회원의 정보보기 클릭", Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, "mem_no TEST : "+hidden_mem_no.getText().toString(), Toast.LENGTH_SHORT).show();
                final Dialog dlg = new Dialog(context);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_tch_mem_list);

                /* 여기에 값 넣어주는 코드 넣기 */
                Log.i("tch_mem_info", "회원정보 DB연동 시작");

                String result = null;
                String reqUrl = "android/jsonClsMemList.gym";
                JSONObject jsonObject = null;
                JSONArray jsonArray = null;

                //int cls_no = Integer.parseInt(vo.getCls_no());
                //Toast.makeText(context, "cls_no = "+cls_no, Toast.LENGTH_SHORT).show();
                Map<String, Object> pMap = new HashMap<>();
                //pMap.put("cls_no", cls_no);
                pMap.put("mem_no", mem_no);
                try{
                    TomcatSend tomcatSend = new TomcatSend();
                    result = tomcatSend.execute(reqUrl, pMap.toString()).get();
                    jsonArray = new JSONArray(result);
                }catch (Exception e){
                    Log.i("tch_mem_info", e.toString());
                }
                Log.i("tch_mem_info", "톰캣서버에서 읽어온 정보"+result);

                if(result != null){
                    Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                }

                // 커스텀 다이얼로그를 노출한다.
                //dlg.show();
            }
        });

        cv_memListMeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, tch_memList_name.getText().toString()+"회원의 메모작성 클릭", Toast.LENGTH_SHORT).show();
                final Dialog dlg = new Dialog(context);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_tch_mem_memo_reg);

                /* 여기에 값 넣어주는 코드 넣기 */

                // 커스텀 다이얼로그를 노출한다.
                dlg.show();
                Log.i("tch_mem_memo", "메모관리 다이얼 로그 show() 성공");
            }
        });

        return convertView;
    }
}
