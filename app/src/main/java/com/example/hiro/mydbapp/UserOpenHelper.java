package com.example.hiro.mydbapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hiro on 5/17/15.
 */
public class UserOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "myapp.db";
    public static final int DB_VERSION = 2;
    public static final String CREATE_TABLE =
            "create table " + UserContract.Users.TABLE_NAME + " (" +
                    UserContract.Users._ID + " integer primary key autoincrement, " +
                    UserContract.Users.COL_NAME + " text," +
                    UserContract.Users.COL_SCORE + " integer)";

    public static final String INIT_TABLE =
            "insert into users (name, score) values" +
                    "('hiro', 42)," +
                    "('wataru', 82)," +
                    "('iwao', 62)," +
                    "('tsunoyu', 72)";

    public static final String DROP_TABLE =
            "drop table if exists users";

    public UserOpenHelper (Context c){
        super(c, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table
        db.execSQL(CREATE_TABLE);

        // init table
        db.execSQL(INIT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop table
        db.execSQL(DROP_TABLE);

        // onCreate
        onCreate(db);


    }
}
