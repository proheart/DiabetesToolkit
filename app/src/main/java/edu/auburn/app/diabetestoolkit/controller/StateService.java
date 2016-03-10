package edu.auburn.app.diabetestoolkit.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.auburn.app.diabetestoolkit.db.DbHelper;
import edu.auburn.app.diabetestoolkit.model.StateModel;

/**
 * Created by liguorui on 3/5/16.
 */
public class StateService {
    private DbHelper dbHelper;

    public StateService(Context ctx){
        dbHelper = new DbHelper(ctx);
    }
    public void add(StateModel model){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "insert into state(time,blood,notes) values(?,?,?)";
        Object[] objs = new Object[] { model.getTime(), model.getBlood(), model.getNote()};
        db.execSQL(sql, objs);
    }
    public List<StateModel> getList(){
        List<StateModel> lists = new ArrayList<StateModel>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from state";
        Cursor cursor = db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            int sid = cursor.getInt(cursor.getColumnIndex("sid"));

            String time = cursor.getString(cursor.getColumnIndex("time"));
            long t = Long.valueOf(time);
            Date d = new Date(t);
            String ti = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm").format(d);

            String blood = cursor.getString(cursor.getColumnIndex("blood"));
            String notes = cursor.getString(cursor.getColumnIndex("notes"));
            lists.add(new StateModel(sid, ti, blood, notes));
        }
        cursor.close();
        return lists;
    }
    public void update(StateModel model){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "update state set time = ?, blood = ? where notes = ?";
        Object[] objs = new Object[] { model.getTime(), model.getBlood(), model.getNote() };
        db.execSQL(sql, objs);
    }
    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from state where sid = ?";
        Object[] objs = new Object[] { id };
        db.execSQL(sql, objs);
    }

    public void clearAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from state";
        db.execSQL(sql);
    }

    public StateModel getLast(){
        StateModel m = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from state order by sid desc";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        int sid = cursor.getInt(cursor.getColumnIndex("sid"));
        String time = cursor.getString(cursor.getColumnIndex("time"));
        long t = Long.valueOf(time);
        Date d = new Date(t);
        String ti = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm").format(d);
        String blood = cursor.getString(cursor.getColumnIndex("blood"));
        String notes = cursor.getString(cursor.getColumnIndex("notes"));
        StateModel model = new StateModel(sid, ti, blood, notes);
        cursor.close();
        return model;
    }

    public String getDaily(){
        int sum = 0;
        List<StateModel> lists = getList();
        int size = lists.size();
        if(size == 0)
            return String.valueOf(0);
        for (int i = 0;i<size;i++){
            String blood = lists.get(i).getBlood();
            int b = Integer.parseInt(blood);
            sum += b;
        }
        int result = sum/size;
        return String.valueOf(result);
    }
    public String getWeek(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from state order by sid desc";
        Cursor cursor = db.rawQuery(sql,null);
        int pos=0;
        int sum = 0;
        while(cursor.moveToNext()){
            pos = cursor.getPosition();
            if(pos==7) break;

            String blood = cursor.getString(cursor.getColumnIndex("blood"));
            int b = Integer.parseInt(blood);
            sum += b;
        }
        cursor.close();
        if(pos == 0)
            return String.valueOf(0);
        return String.valueOf((sum/pos));
    }
    public String getMonth(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from state order by sid desc";
        Cursor cursor = db.rawQuery(sql,null);
        int pos=0;
        int sum = 0;
        while(cursor.moveToNext()){
            pos = cursor.getPosition();
            if(pos==30) break;

            String blood = cursor.getString(cursor.getColumnIndex("blood"));
            int b = Integer.parseInt(blood);
            sum += b;
        }
        cursor.close();
        if(pos == 0)
            return String.valueOf(0);
        return String.valueOf((sum/pos));
    }
}

