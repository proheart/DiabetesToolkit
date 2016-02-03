package edu.auburn.app.diabetestoolkit.utils;

/**
 * Created by liguorui on 2/1/16.
 */
public class SysUtils {
    public static void exitApp() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
