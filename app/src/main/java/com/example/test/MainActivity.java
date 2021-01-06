package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestFragment fragment = TestFragment.getInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainLayout, fragment, "TestFragment")
                .commitAllowingStateLoss();

//        WebView webView = new WebView(this);
//        setContentView(webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setDomStorageEnabled(true);
//        webView.getSettings().setUserAgentString("Mozilla/5.0 (iPhone; CPU iPhone OS 11_2_2 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) CriOS/64.0.3282.112 Mobile/15C202 Safari/604.1");
//        webView.setWebViewClient(new WebViewClient());
//        webView.setWebChromeClient(new WebChromeClient());
//        webView.addJavascriptInterface(this, "JSAction");

//        webView.loadUrl("file:///android_asset/fpt-ai-livechat.html");
//        webView.loadUrl("https://livechat.fpt.ai/v35/src/index.html");

    }

//    @JavascriptInterface
//    public void action(int number) {
//        Log.e("TAG", "action: " + number);
//    }
}