package edu.auburn.app.diabetestoolkit.activity.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import edu.auburn.app.diabetestoolkit.DiabetesApplication;
import edu.auburn.app.diabetestoolkit.R;

/**
 * Created by liguorui on 2/1/16.
 */
public class BaseFragmentActivity extends FragmentActivity{
    private long mExitTime;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN
                && event.getRepeatCount() == 0){
            quit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    protected void quit(){
        if ((System.currentTimeMillis() - mExitTime) > 2000){
            Toast.makeText(this, R.string.app_exit_app_tips, Toast.LENGTH_SHORT).show();;
            mExitTime = System.currentTimeMillis();
        } else {
            DiabetesApplication.getApp().exitApp();
        }
    }
}
