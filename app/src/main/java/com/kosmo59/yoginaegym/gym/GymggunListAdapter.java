package com.kosmo59.yoginaegym.gym;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatImg;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class GymggunListAdapter extends ArrayAdapter {

    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;
    private CardView tch_detail;

    TextView tch_name_dtl = null;
    TextView tch_id_dtl = null;
    TextView tch_gender_dtl = null;
    TextView tch_tel_dtl = null;
    TextView tch_career_dtl = null;
    TextView tch_intro_dtl = null;
    ImageView tch_img_dtl = null;

    //1이면 눌려있을 때, 0이면 안 눌려있을 때
    private int check_num = 0;
    //이미지 버튼
    private ImageButton ib_prHeart_gymggun;
    private ImageButton icon_close;
    //하트 수
    private TextView tv_prHeartNum;
    private int prHeartNum=0;

    public GymggunListAdapter(Context context, int resource, List<Map<String, Object>> clsList) {
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

        TextView tch_name = convertView.findViewById(R.id.tch_name_list);
        TextView tch_tel = convertView.findViewById(R.id.tch_tel_list);
        CircleImageView tch_img = convertView.findViewById(R.id.tch_img);

        tch_name.setText(mList.get(position).get("TCH_NAME").toString());
        tch_tel.setText(mList.get(position).get("TCH_TEL").toString());
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(mContext);
        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_gymggun_detail);

        //강사 디테일에서 사용할 컬럼
        tch_name_dtl = dlg.findViewById(R.id.tch_name_dtl);
        tch_id_dtl = dlg.findViewById(R.id.tch_id_dtl);
        tch_gender_dtl = dlg.findViewById(R.id.tch_gender_dtl);
        tch_tel_dtl = dlg.findViewById(R.id.tch_tel_dtl);
        tch_career_dtl = dlg.findViewById(R.id.tch_career_dtl);
        tch_intro_dtl = dlg.findViewById(R.id.tch_intro_dtl);
        tch_img_dtl = dlg.findViewById(R.id.tch_img_dtl);
        Log.i("GymggunListAdapter","tch_name_dtl : "+tch_name_dtl);
        Log.i("GymggunListAdapter","tch_id_dtl : "+tch_id_dtl);
        Log.i("GymggunListAdapter","tch_gender_dtl : "+tch_gender_dtl);
        Log.i("GymggunListAdapter","tch_tel_dtl : "+tch_tel_dtl);
        Log.i("GymggunListAdapter","tch_career_dtl : "+tch_career_dtl);
        Log.i("GymggunListAdapter","tch_intro_dtl : "+tch_intro_dtl);

        tch_name_dtl.setText(mList.get(position).get("TCH_NAME").toString());
        tch_id_dtl.setText(mList.get(position).get("TCH_ID").toString());
        tch_gender_dtl.setText(mList.get(position).get("TCH_GENDER").toString());
        tch_tel_dtl.setText(mList.get(position).get("TCH_TEL").toString());
        tch_career_dtl.setText(mList.get(position).get("TCH_CAREER").toString());
        tch_intro_dtl.setText(mList.get(position).get("TCH_INTRO").toString());
        //
        try {
            TomcatImg tomcatImg = new TomcatImg();
            String bitImg = tomcatImg.execute(mList.get(position).get("FILE_SEQ").toString()).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            tch_img.setImageBitmap(bitmap);
            tch_img_dtl.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        tch_detail = convertView.findViewById(R.id.tch_detail);
        tch_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 노출한다.
                dlg.show();
                tv_prHeartNum = dlg.findViewById(R.id.tv_prHeartNum);
                tv_prHeartNum.setText(Integer.toString(prHeartNum));

                ib_prHeart_gymggun = dlg.findViewById(R.id.ib_prHeart_gymggun);
                ib_prHeart_gymggun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(check_num == 0){
                            //눌려있지 않은 상태에서 눌렸으면 1로 바꾸어주기 => 눌린상태
                            check_num = 1;
                            ib_prHeart_gymggun.setSelected(true); //이미지버튼이 선택된 상태니까 true
                            ib_prHeart_gymggun.setImageResource(R.drawable.cont_heart); //눌렸으니까 색칠되어있는 하트 이미지로 변경
                            prHeartNum += 1;
                            tv_prHeartNum.setText(Integer.toString(prHeartNum));
                        }
                        else{  //이미지 버튼이 눌려있을 때 (check_num == 1)인 상태
                            check_num = 0; //눌려있을 때 다시 누르면 안 눌린 상태로 돌려야되니까 check_num=0으로
                            ib_prHeart_gymggun.setSelected(false); //이미지 버튼이 선택 안 되어있으니까 상태 false
                            ib_prHeart_gymggun.setImageResource(R.drawable.cont_heart_empty); //다시 눌리지 않은 상태니까 이미지를 빈 하트 이미지로 변경
                            prHeartNum -= 1;
                            tv_prHeartNum.setText(Integer.toString(prHeartNum));
                        }
                    }
                });

                icon_close = dlg.findViewById(R.id.icon_close);
                icon_close.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        dlg.hide();
                    }
                });



            }
        });

        return convertView;
    }

}
