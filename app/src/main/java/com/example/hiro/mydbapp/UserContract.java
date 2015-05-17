package com.example.hiro.mydbapp;

import android.provider.BaseColumns;

/**
 * Created by hiro on 5/17/15.
 */
public final class UserContract {
   public  UserContract() {}

    public static abstract class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COL_NAME = "name";
        public static final String COL_SCORE = "score";
    }
}
