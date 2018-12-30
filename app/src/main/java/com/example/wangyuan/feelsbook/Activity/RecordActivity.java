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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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

        loadView();

        //emotions listview listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String feeling = feelsTable.get(position);
                Intent comment = new Intent(RecordActivity.this, CommentActivity.class);
                comment.putExtra("activity","Record");
                comment.putExtra("feeling", feeling);
                comment.putExtra("comment","");
                startActivity(comment);
            }
        });
    }

    //load all the emotions and it's titles
    public void loadView(){
        emotionData = new ArrayList<>();
        emotionData.add(new Emotion(R.drawable.joy,getString(R.string.joy_now)));
        emotionData.add(new Emotion(R.drawable.anger,getString(R.string.anger_now)));
        emotionData.add(new Emotion(R.drawable.cool,getString(R.string.cool_now)));
        emotionData.add(new Emotion(R.drawable.fear,getString(R.string.fear_now)));
        emotionData.add(new Emotion(R.drawable.love,getString(R.string.love_now)));
        emotionData.add(new Emotion(R.drawable.lucky,getString(R.string.lucky_now)));
        emotionData.add(new Emotion(R.drawable.sick,getString(R.string.sick_now)));
        emotionData.add(new Emotion(R.drawable.speechless,getString(R.string.speechless_now)));
        emotionData.add(new Emotion(R.drawable.surprise,getString(R.string.surprise_now)));
        emotionData.add(new Emotion(R.drawable.sadness,getString(R.string.sadness_now)));

        //set adapter to listview
        RecordAdapter adapter = new RecordAdapter(this,R.layout.emotion_list,emotionData);
        listView.setAdapter(adapter);

    }

    //initialize the hash table for all emotions
    public Hashtable<Integer, String> getTable(){
        Hashtable<Integer, String>  feels = new Hashtable<>();

        feels.put(0,getString(R.string.Joy));
        feels.put(1,getString(R.string.Anger));
        feels.put(2,getString(R.string.Cool));
        feels.put(3,getString(R.string.Fear));
        feels.put(4,getString(R.string.Love));
        feels.put(5,getString(R.string.Lucky));
        feels.put(6,getString(R.string.Sick));
        feels.put(7,getString(R.string.Speechless));
        feels.put(8,getString(R.string.Surprise));
        feels.put(9,getString(R.string.Sadness));

        return feels;
    }

}
