package com.kosmo59.yoginaegym.gym;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.kosmo59.yoginaegym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

public class GymSearchActivity extends AppCompatActivity implements MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener{

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_search);

        //카카오 맵
        mapView = new MapView(GymSearchActivity.this);
        ViewGroup container = findViewById(R.id.map_view);
        //mapView.setCurrentLocationEventListener(this);

        //중심점 입력한 위도 경도로 변경하기
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.4733325,126.8794411), true);

        //마커찍기
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("여기내짐 가산점");
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(37.4733325,126.8794411));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);

        MapPOIItem markerMacNal = new MapPOIItem();
        markerMacNal.setItemName("여기내짐 가산2호점");
        markerMacNal.setTag(0);
        markerMacNal.setMapPoint(MapPoint.mapPointWithGeoCoord(37.4783641,126.8759863));
        markerMacNal.setMarkerType(MapPOIItem.MarkerType.BluePin);
        markerMacNal.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(markerMacNal);

        container.addView(mapView);

        //GymProfile 이동
        /*
        btn_moveGymProfile = findViewById(R.id.btn_moveGymProfile);
        btn_moveGymProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GymSearchActivity.this, GymProfileActivity.class);
                startActivity(intent);
            }
        });
        */

    }
    //GymProfile 이동 함수
    public void moveGymSearchActivity(View view) {
        Intent intent = new Intent(GymSearchActivity.this, GymProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder mapReverseGeoCoder, String s) {

    }

    @Override
    public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder mapReverseGeoCoder) {

    }

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {

    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
