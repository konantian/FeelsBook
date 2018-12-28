package com.example.wangyuan.feelsbook.Activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    TextView prompt;
    int resID;
    int position;
    String mDrawableName;
    String feel;
    String prompt_text;
    String commentsText;
    EditText comments;
    Record record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        //initialize activity elements
        image = findViewById(R.id.displayEmoji);
        comments = findViewById(R.id.optionalComment);
        prompt = findViewById(R.id.feelPrompt);

        String activity = getIntent().getStringExtra("activity");

        //if the previous activity is RecordActivity
        if(activity.equals("Record")){
            initFromRecord();
        }

        //if the previous activity is HistoryActivity
        if(activity.equals("History")){
            initFromHistory();
        }

    }

    public void Save(View v){
        //receive string from previous activity
        String current_time = getIntent().getStringExtra("date");
        //set the comments

        commentsText = comments.getText().toString();

        //Generate a new record
        Record record = new Record(feel,resID,commentsText,current_time);
        MainActivity.recordHistory.add(record);
        finish();
    }

    public void initFromRecord(){

        //set another button to be invisible
        Button button = findViewById(R.id.modifyButton);
        button.setVisibility(View.INVISIBLE); //To set visible

        //set the comment edittext
        comments.setText(getIntent().getStringExtra("comment"));

        //set imageview
        res = getResources();
        mDrawableName = getIntent().getStringExtra("feeling");
        resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        drawable = res.getDrawable(resID);
        image.setImageDrawable(drawable );

        //set the textview
        feel = mDrawableName.substring(0, 1).toUpperCase() + mDrawableName.substring(1);
        prompt_text = "It seems like you are feeling \""+feel+"\" today, do you wanna leave some comments?";
        prompt.setText(prompt_text);
    }

    public void initFromHistory(){

        Button button = findViewById(R.id.saveButton);
        button.setVisibility(View.INVISIBLE); //To set visible

        position = getIntent().getIntExtra("position",0);

        record  = MainActivity.recordHistory.get(position);

        //set comments
        comments.setText(record.getComment());

        //set imageview
        res = getResources();
        String feel = record.getFeel();
        mDrawableName = feel.substring(0, 1).toLowerCase() + feel.substring(1);
        resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        drawable = res.getDrawable(resID);
        image.setImageDrawable(drawable);

        //set the textview
        prompt_text = "It seems like you are feeling \""+feel+"\" today, do you wanna modify your comments?";
        prompt.setText(prompt_text);

    }

    public void Modify(View v){

        String newComments  = comments.getText().toString();
        record.setComment(newComments);

        finish();
    }
}
