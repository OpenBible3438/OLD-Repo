package com.kosmo59.yoginaegym.member;

import androidx.appcompat.app.AppCompatActivity;
import com.kosmo59.yoginaegym.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
Daum 주소검색 API 사용하는 곳
 */

public class MemAddressActivity extends AppCompatActivity {

    private WebView wv_address;

    /* JSP와 연결되는 곳 */
    class MyJavaScriptInterface{
        @JavascriptInterface
        @SuppressWarnings("unused")
        public void processDATA(String data){
            Bundle extra = new Bundle();
            Intent intent = new Intent();
            extra.putString("data",data);
            intent.putExtras(extra);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_address);

        wv_address = findViewById(R.id.wv_address);
        wv_address.getSettings().setJavaScriptEnabled(true);
        wv_address.addJavascriptInterface(new MyJavaScriptInterface(), "Android");
        wv_address.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                //super.onPageFinished(view, url);
                wv_address.loadUrl("javascript:daumPostCode();");
            }
        });
        wv_address.loadUrl("http://192.168.0.27:7777/dev_gym/fitness/util/daumSearch.jsp");
    }
}
