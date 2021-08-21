package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatImg;
import com.kosmo59.yoginaegym.common.TomcatSend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class GymSearchAdapter extends ArrayAdapter {


    List<Map<String, Object>> mList = null;
    int resourceId;
    Context gymSearchActivity = null;
    AppVO vo = null;
    String result = null;
    CircleImageView s_gym_img = null;
    final String Tag = "GymSearchAdapter";
    public GymSearchAdapter(Context gymSearchActivity, int resource, List<Map<String, Object>> gymList, String result) {
        super(gymSearchActivity, resource, gymList);
        this.gymSearchActivity = gymSearchActivity;
        this.mList = gymList;
        this.resourceId = resource;
        this.result = result;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i(Tag, "■■■■■■■■ position : " + position);
     //   Log.i(Tag, "mList.get(position) : " + mList.get(position));
        s_gym_img = (CircleImageView) convertView.findViewById(R.id.s_gym_img);
        TextView s_gym_name = (TextView) convertView.findViewById(R.id.s_gym_name);
        TextView s_gym_addr = (TextView) convertView.findViewById(R.id.s_gym_addr);
        TextView s_gym_tel = (TextView) convertView.findViewById(R.id.s_gym_tel);

        CardView s_gym_card =(CardView)convertView.findViewById(R.id.s_gym_card);


        Log.i(Tag, "convertView : " + convertView);
        final View finalConvertView = convertView;

        s_gym_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                Log.i(Tag, "클릭");

//                Log.i(Tag, "onItemClick() 호출");
//                Log.i(Tag, "mList : " + mList);
//                Log.i(Tag, "position : " + position);
//                Log.i(Tag, "gym_no : " + mList.get(position).get("GYM_NO").toString());

                Intent intent = new Intent(
                        finalConvertView.getContext(), // 현재화면의 제어권자
                        GymProfileActivity.class); // 다음넘어갈 화면

                int cho_gym_no = 0;
                cho_gym_no = (int)Math.round((double)mList.get(position).get("GYM_NO"));
                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                Log.i(Tag, "gym_no : " + cho_gym_no);
               // intent.putExtra("gym_no", cho_gym_no);
                vo = (AppVO) gymSearchActivity.getApplicationContext();
                vo.setGym_no(cho_gym_no);
                gymSearchActivity.startActivity(intent);
            }
        });
        try {
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            String file_seq = jsonObject.getString("FILE_SEQ");
            TomcatImg tomcatImg = new TomcatImg();
            String bitImg = tomcatImg.execute(file_seq).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            s_gym_img.setImageBitmap(bitmap);
        } catch (Exception e) {
            Log.i(Tag, "비트맵 이미지 처리 실패");
            e.printStackTrace();
        }

        s_gym_name.setText(mList.get(position).get("GYM_NAME").toString());
        s_gym_addr.setText(mList.get(position).get("GYM_ADDR").toString());
        s_gym_tel.setText(mList.get(position).get("GYM_TEL").toString());
        return convertView;
    }
}
