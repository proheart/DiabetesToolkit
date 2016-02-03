package edu.auburn.app.diabetestoolkit;

import android.app.Application;

import edu.auburn.app.diabetestoolkit.utils.SysUtils;

/**
 * Created by liguorui on 2/1/16.
 */
public class DiabetesApplication extends Application{
    public final static String TAG = "DiabetesApplication";
    //application object instance
    private static DiabetesApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        initApp();
    }

    private void initApp() {
        instance = this;
    }

    public static DiabetesApplication getApp() {
        return instance;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    public void exitApp() {
        instance = null;
        SysUtils.exitApp();
    }
}
