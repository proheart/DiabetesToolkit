package edu.auburn.app.diabetestoolkit.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by liguorui on 3/2/16.
 */
public class SharedPreferencesUtils {
    private SharedPreferences mSp;

    public SharedPreferencesUtils(Context ctx, String name) {
        mSp = ctx.getSharedPreferences(name, Activity.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPreferences() {
        return mSp;
    }

    public void save(String key, String value) {
        mSp.edit().putString(key, value).commit();
    }

    public void save(String key, int value) {
        mSp.edit().putInt(key, value).commit();
    }

    public void save(String key, long value){
        mSp.edit().putLong(key, value).commit();
    }
    public void save(String key, boolean value) {
        mSp.edit().putBoolean(key, value).commit();
    }

    public String get(String key) {
        return get(key,"");
    }

    public String get(String key, String defaultValue) {
        return mSp.getString(key, defaultValue);
    }

    public int getInt(String key, int defaultValue) {
        return mSp.getInt(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mSp.getBoolean(key, defaultValue);
    }

    /**
     * save
     *
     * @param ctx
     * @param name
     * @param key
     * @param value
     */
    public static void save(Context ctx, String name, String key, String value) {
        SharedPreferences sp = ctx.getSharedPreferences(name,
                Activity.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    /**
     * read
     *
     * @param ctx
     * @param name
     * @param key
     */
    public static String get(Context ctx, String name, String key) {
        return get(ctx, name, key, "");
    }

    /**
     * read
     *
     * @param ctx
     * @param name
     * @param key
     */
    public static String get(Context ctx, String name, String key,
                             String defaultValue) {
        SharedPreferences sp = ctx.getSharedPreferences(name,
                Activity.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }
}
