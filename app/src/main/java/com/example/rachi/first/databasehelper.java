package com.example.rachi.first;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by rachi on 11-02-2018.
 */

public class databasehelper extends SQLiteOpenHelper {
    public static final String Databasename="registered.db";
    public static final String tablename="register";
    public static final String col1="ID";
    public static final String col2="F_name";
    public static final String col3="L_name";
    public static final String col4="password";
    public static final String col5="email";
    public static final String col6="phone";
    public databasehelper(Context context) {
        super(context, Databasename,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" +tablename+("ID INTEGER KEY AUTOINCREMENT,F_name TEXT,L_name TEXT,password TEXT,email TEXT"));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS"+tablename);
        onCreate(db);

    }
}
