package com.example.yogi.database_login;

import android.provider.BaseColumns;
/**
 * Created by YOGI on 3/22/2018.
 */

public class MyTableData {

    MyTableData(){
    }

    public static abstract class DETAILS implements BaseColumns{

        public static final String TABLE_NAME = "TABLENAME";
        public static final String ID = "ID";
        public static final String USERNAME = "USERNAME";
        public static final String EMAILID = "EMAILID";
        public static final String MOBILENUMBER = "MOBILENUMBER";
        public static final String PASSWORD = "PASSWORD";
        public static final String CONFIRMPASSWORD = "CONFIRMPASSWORD";

    public static final String CREATE_STATEMENT = " CREATE TABLE "+ TABLE_NAME + " ( "
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USERNAME + " TEXT, "
            + EMAILID + " TEXT, "
            + MOBILENUMBER + " TEXT, "
            + PASSWORD + " TEXT, "
            + CONFIRMPASSWORD + " TEXT" + ");";

    public static final String DELETE_STATEMENT = "DROP TABLE " + TABLE_NAME;
    }
}