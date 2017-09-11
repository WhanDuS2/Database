package com.thejoeunit.www.database;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
