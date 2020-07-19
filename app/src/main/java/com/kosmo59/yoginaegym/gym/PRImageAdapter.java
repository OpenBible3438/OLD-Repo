package com.kosmo59.yoginaegym.gym;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.TomcatImg;
import com.kosmo59.yoginaegym.common.TomcatSend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* PRImageFragment에 연결되는 Adapter */
public class PRImageAdapter extends ArrayAdapter {
    Context context;
    List<Map<String, Object>> prImageList = null;
    int resourceId;

    int[] arrayFile_seq = null;

    public PRImageAdapter(@NonNull Context context, int resource, List prImageList) {
        super(context, resource, prImageList);
        this.context = context;
        this.resourceId = resource;
        this.prImageList = prImageList;
        this.arrayFile_seq = new int[prImageList.size()];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return prImageList.size();
    }

    @Override
    public Map<String, Object> getItem(int position) {
        return prImageList.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        /*
        반드시 구현해야되는 곳
        Adapter에 추가된 이미지를 표시함
        convertView가 null 일 때 새로운 이미지 객체를 생성해서 화면에 표시
         */
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resourceId, parent, false);
        Log.i("PRImageAdapter", "호출 성공");
        Log.i("PRImageAdapter", "prImageList.size() : "+prImageList.size());

        final ImageView imageView;
        imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,350));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(3,3,3,3 );

        try{
            TomcatImg tomcatImg = new TomcatImg();
            String imsi = prImageList.get(position).get("FILE_SEQ").toString().substring(0, prImageList.get(position).get("FILE_SEQ").toString().length()-2);
            arrayFile_seq[position] = Integer.parseInt(prImageList.get(position).get("FILE_SEQ").toString().substring(0, prImageList.get(position).get("FILE_SEQ").toString().length()-2));
            String bitImg = tomcatImg.execute(imsi).get();
            Bitmap bitmap = tomcatImg.getBitMap(bitImg);
            imageView.setImageBitmap(bitmap);
        }catch (Exception e){
            Log.i("PRImageAdapter", "Exception : "+e.toString());
        }

        //컨텐츠 자세히보기 추가
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dlg = new Dialog(context);
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dlg.setContentView(R.layout.dialog_p_r);

                WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.MATCH_PARENT;
                dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);

                //DB 연동
                Log.i("PRDetail", "DB 연동 시작");
                String result = null;
                String reqUrl = "android/jsonContentsList.gym";
                //Toast.makeText(context, "file_seq = "+arrayFile_seq[position], Toast.LENGTH_SHORT).show();
                //사진 번호 넘겨주기
                int file_seq = arrayFile_seq[position];
                Map<String, Object> pMap = new HashMap<>();
                pMap.put("file_seq", file_seq);
                Log.i("PRDetail", "file_seq : "+arrayFile_seq[position]);
                Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
                try {
                    TomcatSend tomcatSend = new TomcatSend();
                    result = tomcatSend.execute(reqUrl, pMap.toString()).get();
                }catch (Exception e){
                    Log.i("PRDetail", "Exception : "+e.toString());
                }
                Log.i("PRDetail", "톰캣서버에서 읽어온 정보"+result);
                Log.i("PRDetail", "톰캣서버에서 읽어온 정보"+result);
                Gson g = new Gson();
                List<Map<String, Object>> contDetailList = (List<Map<String, Object>>) g.fromJson(result, listType);
                Log.i("PRDetail", "contDetailList.size() : " + contDetailList.size());
                PRDialog prDialog = new PRDialog(context, R.layout.pr_detail_item, contDetailList);
                ListView lv_gym_cont_detail = dlg.findViewById(R.id.lv_gym_cont_detail);
                lv_gym_cont_detail.setAdapter(prDialog);
                //클릭할 때 이미지 그대로 set
                //ImageView iv_cont_detail_img = dlg.findViewById(R.id.iv_cont_detail_img);
                //iv_cont_detail_img.setImageBitmap(((BitmapDrawable)imageView.getDrawable()).getBitmap());
                //다이얼로그 열기
                dlg.show();

            }
        });

        return imageView;
    }
}
