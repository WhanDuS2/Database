package com.thejoeunit.www.database;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thejoeunit.www.database.util.StudentDBManager;

public class MainActivity extends BaseActivity {

    private android.widget.Button insertBtn;
    private android.widget.Button updateBtn;
    private android.widget.Button deleteBtn;
    private android.widget.Button queryBtn;
    private android.widget.EditText contentEdt;

    public StudentDBManager mDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();


    }

    @Override
    public void setupEvents() {

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ContentValues를 다루는 법 : HashMap과 거의 동일.
                ContentValues cv = new ContentValues();
                cv.put("stdNum", "2010");
                cv.put("name", "고동윤");
                cv.put("department", "전기과");
                cv.put("grade", 3);

                long insertedRowId = mDBManager.insert(cv);

                Toast.makeText(mContext, "학생 추가 : " + insertedRowId, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void setValues() {

        mDBManager = StudentDBManager.getInstance(mContext);
    }

    @Override
    public void bindViews() {
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.queryBtn = (Button) findViewById(R.id.queryBtn);
        this.deleteBtn = (Button) findViewById(R.id.deleteBtn);
        this.updateBtn = (Button) findViewById(R.id.updateBtn);
        this.insertBtn = (Button) findViewById(R.id.insertBtn);
    }
}
