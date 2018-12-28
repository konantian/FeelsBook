package com.example.wangyuan.feelsbook.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.wangyuan.feelsbook.Model.Record;
import com.example.wangyuan.feelsbook.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Record> recordHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordHistory = new ArrayList<>();
    }

    //Jump to history activity
    public void viewHistory(View v){
        Intent toHistory = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(toHistory);
    }

    //jump to record activity
    public void recordEmotions(View v){
        Intent toRecord = new Intent(MainActivity.this, RecordActivity.class);
        startActivity(toRecord);
    }
}
