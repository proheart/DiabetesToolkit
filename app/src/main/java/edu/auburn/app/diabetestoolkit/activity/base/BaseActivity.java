package edu.auburn.app.diabetestoolkit.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by liguorui on 2/1/16.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void showToast(String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
    }
    public void showToast(int messageId){
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }
}
