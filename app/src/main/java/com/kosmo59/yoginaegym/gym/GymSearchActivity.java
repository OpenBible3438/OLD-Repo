package com.kosmo59.yoginaegym.gym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;
import com.kosmo59.yoginaegym.member.MemChatListActivity;
import com.kosmo59.yoginaegym.member.MemContentActivity;
import com.kosmo59.yoginaegym.member.MemMainActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

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
    LatLng myPosition = null;
    List<Map<String, Object>> gymList = null;

    //하단바
    public static Activity gymSearchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_search);
        gymSearchActivity = GymSearchActivity.this;
        ////////////////////////////////////DB 연동 시작////////////////////////////////////
        String result = null;
        String reqUrl = "android/jsonGymList.gym";
        final AppVO vo = (AppVO) getApplicationContext();
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

//        if(result != null){
//          //  Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(), "문제 발생.", Toast.LENGTH_LONG).show();
//        }
        Gson g = new Gson();
        gymList = (List<Map<String, Object>>)g.fromJson(result, listType);
        ////////////////////////////////////DB 연동 끝////////////////////////////////////
        Log.i("테스트", "톰캣서버에서 읽어온 정보 : "+gymList.toString());
        GymSearchAdapter gymSearchAdapter = new GymSearchAdapter(GymSearchActivity.this, R.layout.gym_search_list_item, gymList, result);
        s_gymList = findViewById(R.id.s_gymList);
        s_gymList.setAdapter(gymSearchAdapter);
        //////////////////////////////////////어댑터 연결 끝///////////////////////////////

        //xml의 fragment 연결
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(GymSearchActivity.this);


        Button tbtn_gps = (Button) findViewById(R.id.tbtn_gps);
        tbtn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gymSearchMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 15));
            }
        });

    }///end of onCreate

    public void getLocation(){

        // LocationManager 객체를 얻어온다
        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
//            if (tb.isChecked()) {
                Log.i("테스트", "tb.isChecked() 호출");
                // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                        100, // 통지사이의 최소 시간간격 (miliSecond)
                        1, // 통지사이의 최소 변경거리 (m)
                        mLocationListener);
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                        100, // 통지사이의 최소 시간간격 (miliSecond)
                        1, // 통지사이의 최소 변경거리 (m)
                        mLocationListener);
                Log.i("테스트", "latitude : " + latitude + "longitude : " + longitude);

//            } else {
//                lm.removeUpdates(mLocationListener);  //  미수신할때는 반드시 자원해체를 해주어야 한다.
//            }
        } catch (SecurityException ex) {
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.i("테스트", "onMapReady 호출");
        gymSearchMap = googleMap;
        for(int i=0; i<gymList.size(); i++){
            gym_latlng = new LatLng( (double)gymList.get(i).get("GYM_LAT"),  (double)gymList.get(i).get("GYM_LNG"));
            markerOptions = new MarkerOptions();
            markerOptions.position(gym_latlng);
            markerOptions.title(gymList.get(i).get("GYM_NAME").toString());
            markerOptions.snippet(gymList.get(i).get("GYM_ADDR").toString());
            gymSearchMap.addMarker(markerOptions);
        }
        getLocation();

    }

    double longitude = 0.0; //경도
    double latitude = 0.0;   //위도
    double altitude = 0.0;   //고도
    float accuracy = 0.0f;    //정확도

    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            //값은 Location 형태로 리턴되며 좌표 출력 방법은 다음과 같다.

            Log.d("테스트", "onLocationChanged, location:" + location);
            longitude = location.getLongitude(); //경도
            latitude = location.getLatitude();   //위도
            altitude = location.getAltitude();   //고도
            accuracy = location.getAccuracy();    //정확도
            String provider = location.getProvider();   //위치제공자
            //Gps 위치제공자에 의한 위치변화. 오차범위가 좁다.
            //Network 위치제공자에 의한 위치변화
            //Network 위치는 Gps에 비해 정확도가 많이 떨어진다.
           Log.i("테스트","위치정보 : " + provider + "\n위도 : " + longitude + "\n경도 : " + latitude
                    + "\n고도 : " + altitude + "\n정확도 : " + accuracy);
            myPosition = new LatLng(latitude, longitude);
            gymSearchMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 15)); //처음 보여주는 위치
//            gymSearchMap.animateCamera(CameraUpdateFactory.zoomTo(15)); //숫자가 커질수록 상세하게 보여줌
            CircleOptions circle1KM = new CircleOptions().center(myPosition) //원점
                    .radius(30



















































































































































                    )      //반지름 단위 : m
                    .strokeWidth(0f)  //선너비 0f : 선없음
                    .fillColor(Color.parseColor("#6C9FFF"));

            gymSearchMap.addCircle(circle1KM);
        }

        public void onProviderDisabled(String provider) {
            Log.d("테스트", "onProviderDisabled, provider:" + provider);
        }

        public void onProviderEnabled(String provider) {
            Log.d("테스트", "onProviderEnabled, provider:" + provider);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d("테스트", "onStatusChanged, provider:" + provider + ", status:" + status + " ,Bundle:" + extras);
        }
    };


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
