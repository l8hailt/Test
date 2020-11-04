package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        TestFragment fragment = TestFragment.getInstance();
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.mainLayout, fragment, "TestFragment")
//                .commitAllowingStateLoss();

        WebView webView = new WebView(this);
        setContentView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(this, "JSAction");

        webView.loadUrl("file:///android_asset/test.html");

    }

    @JavascriptInterface
    public void action(int number) {
        Log.e("TAG", "action: " + number);
    }
}