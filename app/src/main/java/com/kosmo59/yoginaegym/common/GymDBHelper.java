package com.kosmo59.yoginaegym.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class GymDBHelper extends SQLiteOpenHelper {



    public GymDBHelper(Context context) {
        super(context, "gym_db", null, 1);
        Log.i("테스트", "GymDBHelper 생성자 호출");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("테스트", "GymDBHelper onCreate() 호출");
        String cr_mem_log = "CREATE TABLE mem_log (_id INTEGER PRIMARY KEY AUTOINCREMENT"
                        + ", mem_no INTEGER, reg_date TEXT, ex_date TEXT, log_title TEXT"
                        + ", ex_stime TEXT, ex_etime TEXT, log_cont TEXT);";
        String cr_tch_memo = "CREATE TABLE tch_memo (_id INTEGER PRIMARY KEY AUTOINCREMENT"
                           + ", tch_no INTEGER, mem_no INTEGER, mem_name TEXT"
                           + ", memo_cont TEXT, req_date TEXT, upd_date TEXT)";

        db.execSQL(cr_mem_log);
        db.execSQL(cr_tch_memo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("테스트", "GymDBHelper onUpgrade() 호출");
        db.execSQL("DROP TABLE IF EXISTS mem_log");
        db.execSQL("DROP TABLE IF EXISTS tch_memo");
        onCreate(db);
    }
}
