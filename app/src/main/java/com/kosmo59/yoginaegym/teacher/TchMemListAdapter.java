package com.kosmo59.yoginaegym.teacher;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.GymDBHelper;
import com.kosmo59.yoginaegym.common.TomcatSend;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TchMemListAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> mList = null;
    int resourceId;
    final String Tag = "TchMemListAdapter";
    ImageButton icon_close_info;
    int position = 0;
    AppVO vo = null;

    //private ImageButton icon_close;
    private Button btn_tchMemMemo_ins;
    
    int memoExist = 0; //선택한 회원의 메모가 있는지 없는지 저장
    String getTime = null;// 오늘 날짜 저장
    GymDBHelper gymDBHelper = null;
    SQLiteDatabase db = null;
    
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
        this.position = position;
        final int tch_cho_mem_no = Integer.parseInt((mList.get(position).get("MEM_NO").toString()).split("\\.")[0]);
        Log.i(Tag, "tch_cho_mem_no : " + tch_cho_mem_no);
        vo = (AppVO) context.getApplicationContext();
        Log.i(Tag, "호출");

        final TextView tch_memList_name = convertView.findViewById(R.id.tch_memList_name);
        TextView tch_memList_birth = convertView.findViewById(R.id.tch_memList_birth);
        TextView mem_memList_tel = convertView.findViewById(R.id.mem_memList_tel);

        tch_memList_name.setText(mList.get(position).get("MEM_NAME").toString());
        tch_memList_birth.setText(mList.get(position).get("MEM_BIRTH").toString());
        mem_memList_tel.setText(mList.get(position).get("MEM_TEL").toString());

        //mem_no 아무도 모르게 박아놓기
        final TextView hidden_mem_no = convertView.findViewById(R.id.hidden_mem_no);
        hidden_mem_no.setText(mList.get(position).get("MEM_NO").toString());


        //띄워지는 다이얼로그의 객체 id 설정
        CardView cv_memListDetail = convertView.findViewById(R.id.cv_memListDetail);
        CardView cv_memListMeno = convertView.findViewById(R.id.cv_memListMeno);
        cv_memListDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, tch_memList_name.getText().toString()+"회원의 정보보기 클릭", Toast.LENGTH_SHORT).show();
                Toast.makeText(context, "mem_no TEST : "+hidden_mem_no.getText().toString(), Toast.LENGTH_SHORT).show();
                final Dialog dlg = new Dialog(context);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_tch_mem_info);

                //---다이얼로그 화면 사이즈 조정 시작
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
                //---다이얼로그 화면 사이즈 조정 끝


                /* 여기에 값 넣어주는 코드 넣기 */
                Log.i("tch_mem_info", "회원정보 DB연동 시작");

                String result = null;
                String reqUrl = "android/jsonClsMemList.gym";

                int cls_no = vo.getCls_no();
                Log.i(Tag, "cls_no : "+cls_no);
                Map<String, Object> pMap = new HashMap<>();
                pMap.put("cls_no", cls_no);

                String strMem_no = hidden_mem_no.getText().toString();
                String subMem_no = strMem_no.substring(0, strMem_no.length()-2);
                int mem_no = Integer.parseInt(subMem_no);
                pMap.put("mem_no", mem_no);

                Log.i(Tag, "mem_no : "+mem_no);
                Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
                try{
                    TomcatSend tomcatSend = new TomcatSend();
                    result = tomcatSend.execute(reqUrl, pMap.toString()).get();

                }catch (Exception e){
                    Log.i(Tag, e.toString());
                }
                Log.i(Tag, "톰캣서버에서 읽어온 정보"+result);
                /*if(result != null){
                    Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                }*/
                Gson g = new Gson();
                List<Map<String, Object>> memInfoList = (List<Map<String, Object>>) g.fromJson(result, listType);
                Log.i(Tag, "memInfoList.size() : " + memInfoList.size());
                TchMemInfoAdapter tchMemInfoAdapter = new TchMemInfoAdapter(context, R.layout.tch_mem_info_item, memInfoList);
                ListView lv_tch_mem_info = dlg.findViewById(R.id.lv_tch_mem_info);
                lv_tch_mem_info.setAdapter(tchMemInfoAdapter);
                // 커스텀 다이얼로그를 노출한다.
                dlg.show();

            }
        });

        //메모관리 눌렀을 때
        cv_memListMeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gymDBHelper = new GymDBHelper(context);
                db = gymDBHelper.getWritableDatabase();

                //Toast.makeText(context, tch_memList_name.getText().toString()+"회원의 메모작성 클릭", Toast.LENGTH_SHORT).show();
                final Dialog dlg = new Dialog(context);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_tch_mem_memo_reg);

                EditText tch_memo_cont = dlg.findViewById(R.id.tch_memo_cont);
                TextView tch_memo_regDate = dlg.findViewById(R.id.tch_memo_regDate);
                TextView tch_memo_updDate = dlg.findViewById(R.id.tch_memo_updDate);

                        //---다이얼로그 화면 사이즈 조정 시작
                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
                //---다이얼로그 화면 사이즈 조정 끝

                /* 여기에 값 넣어주는 코드 넣기 */
//                vo.setTch_cho_mem_no(tch_cho_mem_no);
                Log.i(Tag, "tch_cho_mem_no : " + tch_cho_mem_no);
                Log.i(Tag, "vo.tch_no : " + vo.getTchNum());

                /////////////////오늘 날짜 구하기/////////////////////
                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                getTime = simpleDate.format(mDate);
                /////////////////오늘 날짜 구하기 끝/////////////////////

                ///////////////////////////////SQLite /////////////////////////////////////////////
                String memo_sel = "SELECT memo_cont, req_date, upd_date" +
                        " FROM tch_memo" +
                        " WHERE mem_no = " + tch_cho_mem_no +
                        " AND tch_no = " + vo.getTchNum();
                Log.i(Tag, "memo_sel : " + memo_sel);
                Cursor cursor = db.rawQuery(memo_sel, null);
                memoExist = cursor.getCount();
                if(memoExist == 0){
                    tch_memo_cont.setText("");
                    tch_memo_regDate.setText(getTime);
                    tch_memo_updDate.setText(getTime);
                }
                else if (cursor.moveToNext()){
                    int cnt=0;
                    tch_memo_cont.setText(cursor.getString(cnt++));
                    tch_memo_regDate.setText(cursor.getString(cnt++));
                    tch_memo_updDate.setText(cursor.getString(cnt++));
                }
                ///////////////////////////////SQLite 끝/////////////////////////////////////////////
                // 커스텀 다이얼로그를 노출한다.
                dlg.show();
                Log.i("tch_mem_memo", "메모관리 다이얼 로그 show() 성공");


                //메모 닫기 버튼
                ImageButton icon_close = dlg.findViewById(R.id.icon_close);
                icon_close.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dlg.hide();
                    }
                });

                //메모 등록 버튼
                btn_tchMemMemo_ins = dlg.findViewById(R.id.btn_tchMemMemo_ins);
                btn_tchMemMemo_ins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView tch_memo_cont = dlg.findViewById(R.id.tch_memo_cont);
                        TextView tch_memo_updDate = dlg.findViewById(R.id.tch_memo_updDate);
                        String memo_cont = tch_memo_cont.getText().toString();
                        String memo_updDate = tch_memo_updDate.getText().toString();
                        Log.i(Tag, "memo_cont : " + memo_cont + ", memo_regDate : " + memo_updDate);
                        /////////////////////SQLite DB 시작//////////////////////////
                        if(memoExist == 0) {
                            String memo_ins = "INSERT INTO tch_memo (tch_no, mem_no, memo_cont, "
                                    + "req_date, upd_date) VALUES (" + vo.getTchNum() + ", " + tch_cho_mem_no + ", '" + memo_cont + "', "
                                    + "'" + getTime + "', '" + getTime + "')";
                            Log.i(Tag, "memo_ins = " + memo_ins);
                            db.execSQL(memo_ins);
                        }
                        else {
                            String memo_upd = "UPDATE tch_memo SET memo_cont = '" + memo_cont + "', "
                                    + " upd_date = '" + getTime + "'"
                                    + " WHERE mem_no = " + tch_cho_mem_no
                                    + " AND tch_no = " + vo.getTchNum();
                            Log.i(Tag, "memo_upd = " + memo_upd);
                            db.execSQL(memo_upd);
                        }
                        /////////////////////SQLite DB 끝//////////////////////////
                        dlg.hide();
                    }
                });
            }
        });

        return convertView;
    }
}
