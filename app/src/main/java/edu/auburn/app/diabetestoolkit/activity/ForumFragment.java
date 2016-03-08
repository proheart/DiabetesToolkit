package edu.auburn.app.diabetestoolkit.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragment;
import edu.auburn.app.diabetestoolkit.config.Config;

/**
 * Created by liguorui on 2/2/16.
 */
public class ForumFragment extends BaseFragment{
    private static String TAG = "ForumFragment";
    private ViewGroup mFragMainLayout;
    private WebView wvForum;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragMainLayout = (ViewGroup) inflater.inflate(R.layout.fragment_forum,null);
        initView();
        return mFragMainLayout;
    }

    private void initView(){
        wvForum = (WebView) mFragMainLayout.findViewById(R.id.wvForum);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String url = Config.FORUM_URL;
        wvForum.loadUrl(url);
        wvForum.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = wvForum.getSettings();
        settings.setJavaScriptEnabled(true);
        wvForum.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    //complete loading

                } else {
                    //loading
                }
            }
        });
        wvForum.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

}
