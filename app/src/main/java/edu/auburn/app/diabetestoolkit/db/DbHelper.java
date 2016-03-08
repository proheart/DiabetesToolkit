package edu.auburn.app.diabetestoolkit.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by liguorui on 3/5/16.
 */
public class DbHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "diabetes.db";
    private static final int DB_VERSION = 1;
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table state (sid integer primary key autoincrement ,time varchar(20), blood varchar(20), notes varchar(50))";
        db.execSQL(sql);
        sql = "create table medication (" +
                "mid integer primary key autoincrement ," +
                "name varchar(20), form varchar(20), " +
                "dosage varchar(10), " +
                "units varchar(20), " +
                "notes varchar(50), " +
                "schedule varchar(20), " +
                "remind integer(1))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
