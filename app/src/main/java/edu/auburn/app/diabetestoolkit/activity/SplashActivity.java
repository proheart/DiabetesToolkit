package edu.auburn.app.diabetestoolkit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragmentActivity;
import edu.auburn.app.diabetestoolkit.db.DbHelper;
import edu.auburn.app.diabetestoolkit.widget.GifView;

/**
 * Created by liguorui on 2/1/16.
 */
public class SplashActivity extends BaseFragmentActivity {
    private GifView gfLoading;
    private DbHelper helper;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        helper = new DbHelper(this);
        gfLoading = (GifView)findViewById(R.id.gvLoading);
        gfLoading.setMovieResource(R.drawable.loadimg);
        showApp();
    }
    private void showApp(){
        if (mHandler != null){
            mHandler.sendEmptyMessageDelayed(0, 2500);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        helper.close();
    }
}
