package com.kosmo59.yoginaegym.gym;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.libraries.places.api.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kosmo59.yoginaegym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GymSearchActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap gymSearchMap;
    private MarkerOptions markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_search);

        //xml의 fragment 연결
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(GymSearchActivity.this);

    }

    /* 매장이동 */
    public void moveGymSearchActivity(View view) {
        Intent intent = new Intent(GymSearchActivity.this, GymProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gymSearchMap = googleMap;

        //월드메르디앙벤처센터2차/@37.478683,126.876454
        LatLng kosmo = new LatLng(37.478683, 126.876454);
        markerOptions = new MarkerOptions();
        markerOptions.position(kosmo);
        markerOptions.title("여기내짐 가산1호점");
        markerOptions.snippet("가산동 789");
        gymSearchMap.addMarker(markerOptions);

        //대한교역(주)/@37.4778494,126.8779125
        LatLng sample1 = new LatLng(37.4778494, 126.8779125);
        markerOptions = new MarkerOptions();
        markerOptions.position(sample1);
        markerOptions.title("여기내짐 가산2호점");
        markerOptions.snippet("가산동 3438");
        gymSearchMap.addMarker(markerOptions);

        //승일벤처타워/@37.4799603,126.8787942
        LatLng sample2 = new LatLng(37.4799603, 126.8787942);
        markerOptions = new MarkerOptions();
        markerOptions.position(sample2);
        markerOptions.title("터짐 가산점");
        markerOptions.snippet("가산동 12-34");
        gymSearchMap.addMarker(markerOptions);

        gymSearchMap.moveCamera(CameraUpdateFactory.newLatLng(kosmo)); //처음 보여주는 위치
        gymSearchMap.animateCamera(CameraUpdateFactory.zoomTo(15)); //숫자가 커질수록 상세하게 보여줌
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
