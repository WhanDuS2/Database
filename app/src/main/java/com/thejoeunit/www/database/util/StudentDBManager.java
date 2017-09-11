package com.thejoeunit.www.database.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by the on 2017-09-11.
 */

public class StudentDBManager {

//    데이터베이스도 하나의 파일 ( excel : --.xlsx )

    static final String DB_STUDENT = "student.db";
//    학생 정보가 저장되는 표, Table( excel : Sheet )
    static final String TABLE_STUDENT = " Students";
    static final int DB_VERSION = 1;

    Context mContext;

    private static StudentDBManager mDbManager =  null;
    private SQLiteDatabase mDB = null;

    private StudentDBManager(Context context) {
        mContext = context;

        mDB = mContext.openOrCreateDatabase(DB_STUDENT, Context.MODE_PRIVATE, null);

        mDB.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_STUDENT +
        "(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "stdNum TEXT, " +
        "name TEXT, " +
        "department TEXT, " +
        "grade INTEGER" +
        ");");

    }

}
