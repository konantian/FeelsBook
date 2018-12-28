package com.example.wangyuan.feelsbook.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangyuan.feelsbook.Model.Record;
import com.example.wangyuan.feelsbook.R;

public class CommentActivity extends AppCompatActivity {

    Drawable drawable;
    Resources res;
    ImageView image;
    int resID;;
    String mDrawableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        //set imageview by string
        image= findViewById(R.id.displayEmoji);

        res = getResources();
        mDrawableName = getIntent().getStringExtra("feeling");;
        resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        drawable = res.getDrawable(resID);
        image.setImageDrawable(drawable );

        //set the textview
        TextView prompt = findViewById(R.id.feelPrompt);
        prompt.setText("It seems like you are feeling \""+mDrawableName+"\" today, do you wanna leave some comments?");

    }

    public void Save(View v){
        //receive string from previous activity
        String current_time = getIntent().getStringExtra("date");
        //set the comments
        EditText comments = findViewById(R.id.optionalComment);
        String commentsText = comments.getText().toString();


        //Generate a new record
        String feel = mDrawableName.substring(0, 1).toUpperCase() + mDrawableName.substring(1);
        Record record = new Record(feel,resID,commentsText,current_time);
        MainActivity.recordHistory.add(record);
        finish();
    }
}
