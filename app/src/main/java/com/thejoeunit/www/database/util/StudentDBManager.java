package com.thejoeunit.www.database.util;

import android.content.ContentValues;
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

//    DB 구조가 변경될 때, 이를 버전화하여 기록하면, 앱을 업데이트해도 큰 문제 발생 X
    static final int DB_VERSION = 1;

    Context mContext;

//    데이터베이서의 관리자의 경우엔, 동시에 여러개의 객체가 생존해서 좋을게 없음;
//    데이터베이스 관리 시스템은 단 하나의 객체만 존재하도록 보장,
//    => 이러한 기법을 "SingleTone"패턴이라고 함.
//    =>프로그래밍의 디자인패턴이라고 함 ( 코드 설계 디자인)
    private static StudentDBManager mDbManager = null;
    private SQLiteDatabase mDB = null;

    public static StudentDBManager getInstance(Context context) {

        if (mDbManager == null) {
            mDbManager = new StudentDBManager(context);
        }
        return mDbManager;
    }


    private StudentDBManager(Context context) {
        mContext = context;

//        mDB는 새로만들거나, 기존의 데이터베이스 체계를 받아온다.
        mDB = mContext.openOrCreateDatabase(DB_STUDENT, Context.MODE_PRIVATE, null);


//        DB내부에 저장되어, 실제 표(테이블)를 만드는 과정
        mDB.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_STUDENT +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "stdNum TEXT, " +
                "name TEXT, " +
                "department TEXT, " +
                "grade INTEGER" +
                ");");

    }

    public long insert(ContentValues addRowValue){
        return mDB.insert(TABLE_STUDENT, null, addRowValue);
    }
}
