package com.kosmo59.yoginaegym.gym;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class GymSearchAdapter extends ArrayAdapter {


    Context mContext = null;
    List<Map<String, Object>> mList = null;
    int resourceId;
    Context gymSearchActivity = null;
    public GymSearchAdapter(Context gymSearchActivity, Context context, int resource, List<Map<String, Object>> gymList) {
        super(context, resource, gymList);
        this.gymSearchActivity = gymSearchActivity;
        this.mContext = context;
        this.mList = gymList;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i("테스트", "■■■■■■■■ position : " + position);
     //   Log.i("테스트", "mList.get(position) : " + mList.get(position));
        CircleImageView s_gym_img = (CircleImageView) convertView.findViewById(R.id.s_gym_img);
        TextView s_gym_name = (TextView) convertView.findViewById(R.id.s_gym_name);
        TextView s_gym_addr = (TextView) convertView.findViewById(R.id.s_gym_addr);
        TextView s_gym_tel = (TextView) convertView.findViewById(R.id.s_gym_tel);

        CardView s_gym_card =(CardView)convertView.findViewById(R.id.s_gym_card);


        Log.i("테스트", "convertView : " + convertView);
        final View finalConvertView = convertView;

        s_gym_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
                Log.i("테스트", "클릭");

//                Log.i("테스트", "onItemClick() 호출");
//                Log.i("테스트", "mList : " + mList);
//                Log.i("테스트", "position : " + position);
//                Log.i("테스트", "gym_no : " + mList.get(position).get("GYM_NO").toString());

                Intent intent = new Intent(
                        finalConvertView.getContext(), // 현재화면의 제어권자
                        GymProfileActivity.class); // 다음넘어갈 화면

                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
//                Log.i("테스트", "gym_no : " + mList.get(position).get("GYM_NO").toString());
//                intent.putExtra("title", mList.get(position).get("GYM_NO").toString());

                gymSearchActivity.startActivity(intent);


            }
        });
        ///////////이미지 비트맵으로 바꾸기//////////////
//        byte[] imageData = mList.get(position).get("FILEDATA").toString().getBytes();
        byte[] imageData = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(mList.get(position).get("FILEDATA"));
            oos.flush();
            oos.close();
            bos.close();
            imageData = bos.toByteArray();
        } catch (IOException ex) {
            Log.i("테스트", ex.toString());
         }

        Log.i("테스트", "imageData : " + imageData.length );
//        Bitmap bmp = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
//        Log.i("테스트", "bmp = : " + bmp);
//        s_gym_img.setImageBitmap(
//                Bitmap.createScaledBitmap(
//                        bmp
//                        , s_gym_img.getWidth()
//                        , s_gym_img.getHeight()
//                        , false
//                )
//        );
        YuvImage yuvimage=new YuvImage(imageData, ImageFormat.NV21, 100, 100, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        yuvimage.compressToJpeg(new Rect(0, 0, 100, 100), 80, baos);
        byte[] jdata = baos.toByteArray();

        // Convert to Bitmap
        Bitmap bmp1 = BitmapFactory.decodeByteArray(jdata, 0, jdata.length);
        Log.i("테스트", "bmp1 = : " + bmp1);
//        s_gym_name.setText(mList.get(position).get("GYM_NAME").toString());
//        s_gym_addr.setText(mList.get(position).get("GYM_ADDR").toString());
//        s_gym_tel.setText(mList.get(position).get("GYM_TEL").toString());
        s_gym_img.setImageBitmap(
                Bitmap.createScaledBitmap(
                        bmp1
                        , 60
                        , 60
                        , false
                )
        );
////////////////////////////////////

//        byte image[] = mList.get(position).get("FILEDATA").fetchimage(); // gets byte array from the database
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length, options);


        return convertView;
    }


}
