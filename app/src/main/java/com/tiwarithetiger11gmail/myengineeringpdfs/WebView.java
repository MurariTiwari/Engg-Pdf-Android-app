package com.tiwarithetiger11gmail.myengineeringpdfs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {
  private android.webkit.WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wb=(android.webkit.WebView)findViewById(R.id.wv);
        WebSettings ws=wb.getSettings();
        ws.setJavaScriptEnabled(true);
        Bundle b=getIntent().getExtras();
        wb.loadUrl(b.getString("url"));
        wb.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        if(wb.canGoBack())
            wb.goBack();
        else
        super.onBackPressed();
    }
}
