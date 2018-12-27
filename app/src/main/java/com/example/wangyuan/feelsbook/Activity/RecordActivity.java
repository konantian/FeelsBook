package com.example.wangyuan.feelsbook.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wangyuan.feelsbook.Adapter.RecordAdapter;
import com.example.wangyuan.feelsbook.Model.Emotion;
import com.example.wangyuan.feelsbook.R;

import java.util.ArrayList;
import java.util.List;

public class RecordActivity extends AppCompatActivity {

    List<Emotion> emotionData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

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

        final ListView listView = findViewById(R.id.EmotionsList);

        RecordAdapter adapter = new RecordAdapter(this,R.layout.emotion_list,emotionData);
        listView.setAdapter(adapter);

    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

}
