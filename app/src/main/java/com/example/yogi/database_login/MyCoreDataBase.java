package com.example.yogi.database_login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YOGI on 3/22/2018.
 */

public class MyCoreDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyData";
    public static final int VERSION = 1;

    public MyCoreDataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyTableData.DETAILS.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyTableData.DETAILS.DELETE_STATEMENT);
        onCreate(db);
    }
}