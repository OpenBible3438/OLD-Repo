package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
    private CardView cho_teacher;

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

        TextView tch_name = convertView.findViewById(R.id.tch_name);
        TextView tch_tel = convertView.findViewById(R.id.tch_tel);
        CircleImageView tch_img = convertView.findViewById(R.id.tch_img);

        tch_name.setText(mList.get(position).get("TCH_NAME").toString());
        tch_tel.setText(mList.get(position).get("TCH_TEL").toString());
        try {
            TomcatImg tomcatImg = new TomcatImg();
            String bitImg = tomcatImg.execute(mList.get(position).get("FILE_SEQ").toString()).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            tch_img.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //버튼 id를 찾은 후 setOnclickListener()메소드를 사용한다.
        cho_teacher = convertView.findViewById(R.id.teacher);
        cho_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                GymggunDetailDialog gymggunDetailDialog = new GymggunDetailDialog(mContext);

                // 커스텀 다이얼로그를 호출한다.
                gymggunDetailDialog.openGymggunDetailDialog();
            }
        });

        return convertView;
    }

}
