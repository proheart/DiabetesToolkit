package edu.auburn.app.diabetestoolkit.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseActivity;

/**
 * Created by liguorui on 3/3/16.
 */
public class WebViewActivity extends BaseActivity implements View.OnClickListener{
    private TextView tvName, btnBack;
    private WebView wvRead;
    private String name, url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        initData();
        initView();
    }
    private void initView(){
        tvName = (TextView)findViewById(R.id.tvName);
        if(!TextUtils.isEmpty(name)) tvName.setText(name);
        btnBack = (TextView) findViewById(R.id.btnBack);
        wvRead = (WebView) findViewById(R.id.wvRead);
        btnBack.setOnClickListener(this);
        wvRead.loadUrl(url);
        wvRead.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = wvRead.getSettings();
        settings.setJavaScriptEnabled(true);
        wvRead.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    //complete loading

                } else {
                    //loading
                }
            }
        });

    }
    private void initData(){
        name = getIntent().getStringExtra("name");
        url = getIntent().getStringExtra("url");

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnBack){
            this.finish();
        }
    }
}
