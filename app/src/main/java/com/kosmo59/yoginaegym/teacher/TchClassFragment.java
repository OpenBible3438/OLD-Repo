package com.kosmo59.yoginaegym.teacher;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosmo59.yoginaegym.R;

import java.util.ArrayList;

public class TchClassFragment extends Fragment {
    private Context context;
    private ImageButton icon_close;
    private Button btn_tchMemList;

    private Spinner spn_tchClass;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;




    public TchClassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tch_class, container, false);
        context = container.getContext();

        arrayList = new ArrayList<>();
        arrayList.add("여기내짐");
        arrayList.add("터짐");
        arrayList.add("마음가짐");

        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, arrayList);

        spn_tchClass = view.findViewById(R.id.spn_tchClass);
        spn_tchClass.setAdapter(arrayAdapter);
        spn_tchClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                Toast.makeText(context,arrayList.get(i)+" 매장입니다", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        btn_tchMemList = view.findViewById(R.id.btn_tchMemList);
        btn_tchMemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                final Dialog dlg = new Dialog(context);

                // 액티비티의 타이틀바를 숨긴다.
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                dlg.setContentView(R.layout.dialog_tch_mem_list);

                // 커스텀 다이얼로그를 노출한다.
                dlg.show();

                icon_close = dlg.findViewById(R.id.icon_close);
                icon_close.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        dlg.hide();
                    }
                });


                //----------------------------------------------------------------- 여기서 부터 다이얼로그 안 다이얼로그

                //----------------------------------------------------------------- 자세히 보기 버튼
                Button btn_tchMemDetail = dlg.findViewById(R.id.btn_tchMemDetail);
                btn_tchMemDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                        final Dialog dlg = new Dialog(context);

                        // 액티비티의 타이틀바를 숨긴다.
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                        // 커스텀 다이얼로그의 레이아웃을 설정한다.
                        dlg.setContentView(R.layout.dialog_tch_mem_info);

                        // 커스텀 다이얼로그를 노출한다.
                        dlg.show();

                        icon_close = dlg.findViewById(R.id.icon_close);
                        icon_close.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                dlg.hide();
                            }
                        });

                    }
                });

                //----------------------------------------------------------------- 인바디 보기 버튼
                final Button btn_tchmemAtt = dlg.findViewById(R.id.btn_tchMemInbody);
                btn_tchmemAtt.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                        final Dialog dlg = new Dialog(context);

                        // 액티비티의 타이틀바를 숨긴다.
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                        // 커스텀 다이얼로그의 레이아웃을 설정한다.
                        dlg.setContentView(R.layout.dialog_tch_mem_inbody);

                        // 커스텀 다이얼로그를 노출한다.
                        dlg.show();

                        icon_close = dlg.findViewById(R.id.icon_close);
                        icon_close.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                dlg.hide();
                            }
                        });
                    }
                });


                //----------------------------------------------------------------- 메모 보기 버튼
                final Button btn_tchMemMemo = dlg.findViewById(R.id.btn_tchMemMemo);
                btn_tchMemMemo.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                        final Dialog dlg = new Dialog(context);

                        // 액티비티의 타이틀바를 숨긴다.
                        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                        // 커스텀 다이얼로그의 레이아웃을 설정한다.
                        dlg.setContentView(R.layout.dialog_tch_mem_memo);

                        // 커스텀 다이얼로그를 노출한다.
                        dlg.show();

                        icon_close = dlg.findViewById(R.id.icon_close);
                        icon_close.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                dlg.hide();
                            }
                        });


                        //---------------------------------------------------------------새 메모 등록
                        CardView cv_tchMemMemo_reg = dlg.findViewById(R.id.cv_tchMemMemo_reg);
                        cv_tchMemMemo_reg.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                                final Dialog dlg = new Dialog(context);

                                // 액티비티의 타이틀바를 숨긴다.
                                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                                dlg.setContentView(R.layout.dialog_tch_mem_memo_reg);

                                // 커스텀 다이얼로그를 노출한다.
                                dlg.show();

                                icon_close = dlg.findViewById(R.id.icon_close);
                                icon_close.setOnClickListener(new View.OnClickListener(){

                                    @Override
                                    public void onClick(View v) {
                                        dlg.hide();
                                    }
                                });

                                Button btn_tchMemMemo_ins = dlg.findViewById(R.id.btn_tchMemMemo_ins);
                                btn_tchMemMemo_ins.setOnClickListener(new View.OnClickListener(){

                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context,"등록완료", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        });

                        //---------------------------------------------------------------메모 확인
                        CardView cv_tchMemMemo_1 = dlg.findViewById(R.id.cv_tchMemMemo_1);
                        cv_tchMemMemo_1.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                                final Dialog dlg = new Dialog(context);

                                // 액티비티의 타이틀바를 숨긴다.
                                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

                                // 커스텀 다이얼로그의 레이아웃을 설정한다.
                                dlg.setContentView(R.layout.dialog_tch_mem_memo_detail);

                                // 커스텀 다이얼로그를 노출한다.
                                dlg.show();

                                icon_close = dlg.findViewById(R.id.icon_close);
                                icon_close.setOnClickListener(new View.OnClickListener(){

                                    @Override
                                    public void onClick(View v) {
                                        dlg.hide();
                                    }
                                });

                                Button btn_tchMemMemoDetail_upd = dlg.findViewById(R.id.btn_tchMemMemoDetail_upd);
                                btn_tchMemMemoDetail_upd.setOnClickListener(new View.OnClickListener(){

                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context,"수정완료", Toast.LENGTH_SHORT).show();
                                    }
                                });

                                Button btn_tchMemMemoDetail_del = dlg.findViewById(R.id.btn_tchMemMemoDetail_del);
                                btn_tchMemMemoDetail_del.setOnClickListener(new View.OnClickListener(){

                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context,"삭제완료", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                    }
                });

                //----------------------------------------------------------------- 출석 체크 버튼
                final Button btn_tchMemAtt = dlg.findViewById(R.id.btn_tchMemAtt);
                btn_tchMemAtt.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"출석 체크 완료",Toast.LENGTH_SHORT).show();
                        btn_tchMemAtt.setEnabled(false);
                    }
                });
            }
        });
        return view;
    }
}
