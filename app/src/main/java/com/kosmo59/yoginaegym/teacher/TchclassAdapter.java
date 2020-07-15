package com.kosmo59.yoginaegym.teacher;

import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TchclassAdapter extends ArrayAdapter {

    public static final String TAG = "TchclassAdapter";
    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;

    //private Context context;
    private ImageButton icon_close;
    private Button btn_tchMemList;

    //수강생 보기 버튼 => 수강생 리스트 다이얼로그
    private ListView mem_listView;
    List<Map<String, Object>> mem_list = null;


    public TchclassAdapter(Context context, int resource, List<Map<String, Object>> clsList) {
        super(context, resource, clsList);
        this.mContext = context;
        this.mList = clsList;
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
        /*final View view = mLayoutInflater.inflate(R.layout.tchclasslistview_item, null);*/
        Log.i(TAG, "■■■■■■■■ position : " + position);

        CardView tch_class = (CardView) convertView.findViewById(R.id.tch_class);
        TextView cls_name = (TextView) convertView.findViewById(R.id.cls_name);
        TextView cls_stime = (TextView) convertView.findViewById(R.id.cls_stime);
        TextView cls_etime = (TextView) convertView.findViewById(R.id.cls_etime);
        TextView cls_day = (TextView) convertView.findViewById(R.id.cls_day);
        TextView cls_cnt = (TextView) convertView.findViewById(R.id.cls_cnt);

        String cls_no = mList.get(position).get("CLS_NO").toString();
        final String cls_no_result = cls_no.substring(0, cls_no.length()-2);

        cls_name.setText(mList.get(position).get("CLS_NAME").toString());
        cls_stime.setText(mList.get(position).get("CLS_STIME").toString());
        cls_etime.setText(mList.get(position).get("CLS_ETIME").toString());
        cls_day.setText(mList.get(position).get("CLS_DAY").toString());
        cls_cnt.setText(""+Integer.valueOf((int)Math.round((double)mList.get(position).get("MEM_NUM"))));
        mList.get(position).get("MEM_NUM");
        final View finalConvertView = convertView;
        tch_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.

            final Dialog dlg = new Dialog(finalConvertView.getContext());

            // 액티비티의 타이틀바를 숨긴다.
            dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

            // 커스텀 다이얼로그의 레이아웃을 설정한다.
            dlg.setContentView(R.layout.dialog_tch_mem_list);

            // 커스텀 다이얼로그를 노출한다.
            dlg.show();
            }
        });


        //----------------------------------------------------------------- 수강생 보기 버튼


        btn_tchMemList = convertView.findViewById(R.id.btn_tchMemList);
        btn_tchMemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                Log.i("테스트", "context : " + mContext);
                final Dialog dlg = new Dialog(mContext);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_tch_mem_list);

                //자세히보기
                ListView tch_mem_list = null;

                String result = null;
                String reqUrl = "android/jsonClsMemList.gym";

                Map<String, Object> pMap = new HashMap<>();
                pMap.put("cls_no", cls_no_result);
                Type listType = new TypeToken<List<Map<String, Object>>>() {
                }.getType();
                Log.i("테스트", "받아온 cls_no : " + cls_no_result);
                try {
                    TomcatSend tomcatSend = new TomcatSend();
                    result = tomcatSend.execute(reqUrl, pMap.toString()).get();
                } catch (Exception e) {
                    Log.i("테스트", "Exception : " + e.toString());
                }
                Log.i("테스트", "톰캣서버에서 읽어온 정보 : " + result);
//                if (result != null) {
//                    Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(mContext, "문제 발생.", Toast.LENGTH_LONG).show();
//                }
                Gson g = new Gson();
                List<Map<String, Object>> memList = (List<Map<String, Object>>) g.fromJson(result, listType);
                Log.i("테스트", "memList.size() : " + memList.size());
                TchMemListAdapter tchMemListAdaper = new TchMemListAdapter(mContext, R.layout.tchmemlistview_item, memList);
                tch_mem_list = dlg.findViewById(R.id.tch_mem_list);
                tch_mem_list.setAdapter(tchMemListAdaper);
                // 커스텀 다이얼로그를 노출한다.
                dlg.show();

                //CardView tch_mem_list = dlg.findViewById(R.id.tch_mem_list);

                icon_close = dlg.findViewById(R.id.icon_close);
                icon_close.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dlg.hide();
                    }
                });
                //----------------------------------------------------------------- 여기서부터 다이얼로그 안 다이얼로그
            }
        });
        return convertView;
    }// end of getView
}// end of class