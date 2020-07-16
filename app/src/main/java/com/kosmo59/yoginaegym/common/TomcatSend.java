package com.kosmo59.yoginaegym.common;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TomcatSend extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {

        String apiURL = "http://192.168.0.251:7777/dev_gym/fitness/"; // 고정 URL
        String sendUrl = null;
        String sendMsg = null;      //안드로이드 앱에서 입력한 ID와 PW을 담아서 Tomcat Server에 전달
        String receiveMsg = null;   // 톰캣서버를 통해 처리된 결과를 받아서 담을 변수 - 응답.

        if(strings != null && strings.length > 0) {
            sendUrl = strings[0]; // android/memInfoIns.gym
            // {mem_id=hjho, mem_pw=123}
            String sendMsgBuf = strings[1].replaceAll(", ", "&");
            Log.i("테스트", "sendMsgBuf : " + sendMsgBuf);
            // {mem_id=hjho&mem_pw=123}
            sendMsg = sendMsgBuf.substring(1, sendMsgBuf.length()-1);
            Log.i("테스트", "sendMsg : " + sendMsg);
            // mem_id=hjho&mem_pw=123
            // 안드로이드 바인더 필요
            Log.i("테스트"," ** Message  :"+sendMsg);
            Log.i("테스트"," ** URL  :"+apiURL+sendUrl);
        } else {
            return "";
        }
        try {
            URL url = new URL(apiURL+sendUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            con.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            //톰캣서버에 전송할 메시지 처리
            osw.write(sendMsg);
            osw.flush();
            int responsCode = con.getResponseCode();
            BufferedReader br = null;
            if(responsCode == con.HTTP_OK) {
                br = new BufferedReader(
                        new InputStreamReader(
                                con.getInputStream(),"UTF-8"));
                String inputLine = null;
                StringBuffer sb_res = new StringBuffer();
                while((inputLine = br.readLine())!=null) {
                    sb_res.append(inputLine);
                }
                receiveMsg = sb_res.toString();
                Log.i("TomcatSend","톰캣처리결과 :"+receiveMsg);
            } else {
                return "";
            }
        } catch (Exception e) {
            Log.i("TomcatSend","Exception : "+e.toString());
        }
        return receiveMsg;
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.i("TomcatSend","onPostExecute 호출 result="+result);
    }
}
