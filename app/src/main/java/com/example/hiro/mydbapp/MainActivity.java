package com.example.hiro.mydbapp;

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
        Cursor c = null;
        c = db.query(UserContract.Users.TABLE_NAME,
                null,
                UserContract.Users.COL_SCORE + "> ?",
                new String[] { "50" },
                null,
                null,
                UserContract.Users.COL_SCORE + " desc",
                "1"
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
