package com.example.wangyuan.feelsbook.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wangyuan.feelsbook.Adapter.HistoryAdapter;
import com.example.wangyuan.feelsbook.R;

public class HistoryActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listView = findViewById(R.id.recordHistory);

        //set adapter to listview
        HistoryAdapter adapter = new HistoryAdapter(this,R.layout.history_list,MainActivity.recordHistory);
        listView.setAdapter(adapter);

    }
}
