package com.kosmo59.yoginaegym.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TomcatImg extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {

        String apiURL = "http://192.168.0.26:7777/dev_gym/fitness/android/getImg.gym?file_seq="; // 고정 URL
        String sendMsg = null;      //안드로이드 앱에서 입력한 ID와 PW을 담아서 Tomcat Server에 전달
        InputStream is = null;
        String strBitImg = null;
        HttpURLConnection con = null;
        final String TAG = "TomcatImg";
        if (strings != null && strings.length > 0) {
            sendMsg = strings[0]; // android/memInfoIns.gym
            Log.i(TAG, " ** FILE_SEQ  :" + sendMsg);
            Log.i(TAG, " ** URL  :" + apiURL+sendMsg);
        } else {
            Log.i(TAG, " ** FILE_SEQ 가 없습니다.   :" + sendMsg);
            return "";
        }
        try {
            URL url = new URL(apiURL+sendMsg);
            con = (HttpURLConnection) url.openConnection();
            con.setDoInput(true);
            con.setConnectTimeout(8000);
            con.connect(); //연결
            is = con.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            if(bitmap == null) return null;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
            byte[] bytes = baos.toByteArray();
            strBitImg = Base64.encodeToString(bytes, Base64.DEFAULT);
        } catch (Exception e) {
            Log.i("TomcatSend", "Exception : " + e.toString());
        } finally {
            if(con != null) {
                con.disconnect();
            }
        }
        return strBitImg;
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.i("TomcatImg", "onPostExecute 호출 result=" + result);
    }

    public Bitmap getBitMap(String strBitImg) {
        Bitmap bitmap = null;
        try {
            byte[] byteBitImg = Base64.decode(strBitImg, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(byteBitImg, 0, byteBitImg.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
