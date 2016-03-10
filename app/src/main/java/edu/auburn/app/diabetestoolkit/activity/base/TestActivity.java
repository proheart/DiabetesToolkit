package edu.auburn.app.diabetestoolkit.activity.base;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.utils.SharedPreferencesUtils;

/**
 * Created by liguorui on 3/2/16.
 */
public class TestActivity extends BaseActivity{
    private  WebView webView;
    private SharedPreferencesUtils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_forum);
//        utils = new SharedPreferencesUtils(this,"test");
//        utils.save("id", 123);
//        showToast(utils.get("id")+"");
    }

    private void init(){
        webView = (WebView) findViewById(R.id.wvForum);
        String url = "http://www.google.com";
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        //启用支持javascript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    // 网页加载完成

                } else {
                    // 加载中

                }

            }
        });
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        getFileName();
    }
    private void getFileName(){
        AssetManager assetManager = getAssets();
        String[] files = null;
        try {
            files = assetManager.list("sys");
            Log.i("testactivity",files[0]);
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            if(webView.canGoBack()) {
                webView.goBack();//返回上一页面
                return true;
            }
            else {
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
