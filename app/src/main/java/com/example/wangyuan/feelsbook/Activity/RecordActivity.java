package com.example.wangyuan.feelsbook.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.wangyuan.feelsbook.Adapter.RecordAdapter;
import com.example.wangyuan.feelsbook.Model.Emotion;
import com.example.wangyuan.feelsbook.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

public class RecordActivity extends AppCompatActivity {

    List<Emotion> emotionData;
    ListView listView;
    Hashtable<Integer, String> feelsTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        listView = findViewById(R.id.EmotionsList);

        feelsTable = getTable();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.CANADA);
        final String current_time=dateFormat.format(date);

        loadView();

        //emotions listview listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String feeling = feelsTable.get(position);
                Intent comment = new Intent(RecordActivity.this, CommentActivity.class);
                comment.putExtra("feeling", feeling);
                comment.putExtra("date",current_time);
                startActivity(comment);
            }
        });
    }

    //load all the emotions and it's titles
    public void loadView(){
        emotionData = new ArrayList<>();
        emotionData.add(new Emotion(R.drawable.joy,"Joy"));
        emotionData.add(new Emotion(R.drawable.anger,"Anger"));
        emotionData.add(new Emotion(R.drawable.cool,"Cool"));
        emotionData.add(new Emotion(R.drawable.fear,"Fear"));
        emotionData.add(new Emotion(R.drawable.love,"Love"));
        emotionData.add(new Emotion(R.drawable.lucky,"Lucky"));
        emotionData.add(new Emotion(R.drawable.sick,"Sick"));
        emotionData.add(new Emotion(R.drawable.speechless,"Speechless"));
        emotionData.add(new Emotion(R.drawable.surprise,"Surprise"));
        emotionData.add(new Emotion(R.drawable.sadness,"Sadness"));

        //set adapter to listview
        RecordAdapter adapter = new RecordAdapter(this,R.layout.emotion_list,emotionData);
        listView.setAdapter(adapter);

    }

    //initialize the hash table for all emotions
    public Hashtable<Integer, String> getTable(){
        Hashtable<Integer, String>  feels = new Hashtable<Integer, String>();

        feels.put(0,"joy");
        feels.put(1,"anger");
        feels.put(2,"cool");
        feels.put(3,"fear");
        feels.put(4,"love");
        feels.put(5,"lucky");
        feels.put(6,"sick");
        feels.put(7,"speechless");
        feels.put(8,"surprise");
        feels.put(9,"sadness");

        return feels;
    }

}
