package com.example.wangyuan.feelsbook.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.wangyuan.feelsbook.Adapter.HistoryAdapter;
import com.example.wangyuan.feelsbook.R;

public class HistoryActivity extends AppCompatActivity {

    ListView listView;
    public HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listView = findViewById(R.id.recordHistory);

        //set adapter to listview
        adapter = new HistoryAdapter(this,R.layout.history_list,MainActivity.recordHistory);
        listView.setAdapter(adapter);

        //listview listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent editFeeling = new Intent(HistoryActivity.this, CommentActivity.class);

                editFeeling.putExtra("activity","History");
                editFeeling.putExtra("position",position);

                startActivity(editFeeling);

            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.notifyDataSetChanged();
    }

}
