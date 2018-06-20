package com.example.demo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class DBManager {
    private Context context;
    private static DBManager dbManager;

    private DBManager(Context context) {
        this.context = context;
    }

    public static DBManager getInstanace(Context context) {
        if (dbManager == null) {
            dbManager = new DBManager(context);
        }
        return dbManager;
    }

    /**
     * 插入数据库
     * @param db
     * @param sql 插入的语句
     * @param values 插入的数据
     */
    public void insert(SQLiteDatabase db,String sql,Object[] values){
        db.execSQL(sql, values);
        db.close();
    }
    public String query(SQLiteDatabase db,String sql){
        Cursor cursor =db.rawQuery(sql,null);
        StringBuffer sb = new StringBuffer();
        while (cursor.moveToNext()){
            int id =cursor.getInt(0);
            String name=cursor.getString(1);
            int age=cursor.getInt(2);
            String sex=cursor.getString(3);
            sb.append("id=").append(id)
                    .append("name=").append(name)
                    .append("age=").append(age)
                    .append("sex").append(sex)
                    .append("\r\n");
        }
        db.close();
        return sb.toString();
    }
    public void delete(SQLiteDatabase db,String sql,Object[] where){
        db.execSQL(sql,where);
        db.close();
    }
//    public void update(SQLiteDatabase db,String sql,Object[] where){
//        sql="Update user set name=? where id=?";
//        db.execSQL(sql,where);
//        db.close();
//    }
    public void update(SQLiteDatabase db,ContentValues values,String whereClause,String[] whereArgs){
       int cursor = db.update("user", values,whereClause,whereArgs);
        Log.e("cursor=",cursor+"");
        db.close();

    }
    public void addColumn(SQLiteDatabase db){
        db.execSQL("alter table user add column mobileophone varchar(24)");
        db.close();
    }
}
