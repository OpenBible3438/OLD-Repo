package com.kosmo59.yoginaegym.gym;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymSearchActivity extends AppCompatActivity implements OnMapReadyCallback {
    private Context mContext;
    private GoogleMap gymSearchMap;
    private MarkerOptions markerOptions;
    private LatLng gym_latlng;
    private int choGym_no = 0;
    private ListView s_gymList;

    List<Map<String, Object>> gymList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_search);
        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonGymList.gym";
        AppVO vo = (AppVO) getApplicationContext();
        String nowMem = null;//여기서는 딱히 필요 없음
        Map<String, Object> memMap = new HashMap<>();//여기서는 딱히 필요 없음
        memMap.put("gym_no", 1);//여기서는 딱히 필요 없음
        nowMem = memMap.toString();
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Log.i("테스트", "nowMem : " + nowMem);
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(reqUrl, nowMem).get();
        } catch (Exception e){
            Log.i("테스트", "Exception : "+e.toString());
        }
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+result);

        if(result != null){
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "문제 발생.", Toast.LENGTH_LONG).show();
        }
        Gson g = new Gson();
        gymList = (List<Map<String, Object>>)g.fromJson(result, listType);
        ////////////////////////////////////DB 연동 끝////////////////////////////////////

        GymSearchAdapter gymSearchAdapter = new GymSearchAdapter(getApplicationContext(), R.layout.gym_search_list_item, gymList);
        s_gymList = findViewById(R.id.s_gymList);
        s_gymList.setAdapter(gymSearchAdapter);

        //xml의 fragment 연결
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(GymSearchActivity.this);

    }

    /* 매장이동 */
    public void moveGymSearchActivity(View view) {
        Intent intent = new Intent(GymSearchActivity.this, GymProfileActivity.class);
        intent.putExtra("gym_no", choGym_no);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gymSearchMap = googleMap;
        for(int i=0; i<gymList.size(); i++){
            gym_latlng = new LatLng( (double)gymList.get(i).get("GYM_LAT"),  (double)gymList.get(i).get("GYM_LNG"));
            markerOptions = new MarkerOptions();
            markerOptions.position(gym_latlng);
            markerOptions.title(gymList.get(i).get("GYM_NAME").toString());
            markerOptions.snippet(gymList.get(i).get("GYM_ADDR").toString());
            gymSearchMap.addMarker(markerOptions);
        }
        LatLng kosmo = new LatLng(37.4785562, 126.8785191);
        gymSearchMap.moveCamera(CameraUpdateFactory.newLatLng(kosmo)); //처음 보여주는 위치
        gymSearchMap.animateCamera(CameraUpdateFactory.zoomTo(15)); //숫자가 커질수록 상세하게 보여줌
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
