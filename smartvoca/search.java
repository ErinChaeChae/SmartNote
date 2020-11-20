
package com.example.smartvoca;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
//영어 학습시

public class search extends AppCompatActivity {
    private WebView mWebView; //웹뷰 선언
    private WebSettings mWebSettings; //웹뷰 세팅

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mWebView = (WebView) findViewById(R.id.webview);

        mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        mWebSettings = mWebView.getSettings(); //세부 세팅 등록
        mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
        mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부

        //영어
        if(English.num == 1){
            mWebView.loadUrl("https://en.dict.naver.com/#/main"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
            English.num = 0;
        }
        //일본어
        else if(Japanese.num1 == 2){
            mWebView.loadUrl("https://ja.dict.naver.com/#/main");
            Japanese.num1 = 0;
        }
        //JAVA
        else if(Java.num2 == 3){
            mWebView.loadUrl("https://docs.oracle.com/javase/7/docs/api/");
            Java.num2 = 0;
        }
        //DB
        else if(Database.num3 == 4){
            mWebView.loadUrl("https://dev.mysql.com/doc/refman/8.0/en/select.html");
            Database.num3 = 0;
        }
        else
            System.out.print("오류");
    }

}