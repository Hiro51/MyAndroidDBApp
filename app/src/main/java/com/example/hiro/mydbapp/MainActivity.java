package com.example.hiro.mydbapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // table の定義 - contract class
        // users (name, score)

        // open helper

        // open db
        UserOpenHelper userOpenHelper = new UserOpenHelper(this);
        SQLiteDatabase db = userOpenHelper.getWritableDatabase();

        // 処理 select, insert, update, delete
//        ContentValues newUser = new ContentValues();
//        newUser.put(UserContract.Users.COL_NAME, "tanaka");
//        newUser.put(UserContract.Users.COL_SCORE, 44);
//        long newId = db.insert(
//                UserContract.Users.TABLE_NAME,
//                null,
//                newUser
//        );
//
//        ContentValues newScore = new ContentValues();
//        newScore.put(UserContract.Users.COL_SCORE, 100);
//        int updatedCount = db.update(
//                UserContract.Users.TABLE_NAME,
//                newScore,
//                UserContract.Users.COL_NAME + "=?",
//                new String[]{ "wataru" }
//        );
//
//        int deletedCount = db.delete(
//                UserContract.Users.TABLE_NAME,
//                UserContract.Users.COL_NAME + "=?",
//                new String[]{ "tsunoyu" }
//        );

        Cursor c = null;
        c = db.query(UserContract.Users.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        Log.v("DB_TEST", "Count: " + c.getCount());
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex(UserContract.Users._ID));
            String name = c.getString(c.getColumnIndex(UserContract.Users.COL_NAME));
            int score = c.getInt(c.getColumnIndex(UserContract.Users.COL_SCORE));

            Log.v("DB_TEST", "id: " + id + " name: " + name + " score: " +score);
        }

        c.close();

        // close db
        db.close();

    }
}
