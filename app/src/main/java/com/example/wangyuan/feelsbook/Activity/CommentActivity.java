package com.example.wangyuan.feelsbook.Activity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangyuan.feelsbook.Model.Record;
import com.example.wangyuan.feelsbook.R;
import com.google.gson.Gson;
import java.util.Date;
import java.util.HashMap;

import tyrantgit.explosionfield.ExplosionField;

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
    Date date;
    HashMap<String, String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        //initialize activity elements
        image = findViewById(R.id.displayEmoji);
        comments = findViewById(R.id.optionalComment);
        prompt = findViewById(R.id.feelPrompt);

        String[] titleKeys = getResources().getStringArray(R.array.hint_titles);
        String[] titleValues = getResources().getStringArray(R.array.hint_values);

        titles = new HashMap<>();

        for(int i = 0; i < titleKeys.length; i++) {
            titles.put(titleKeys[i], titleValues[i]);
        }

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

    //save new record to local file
    public void Save(View v){

        //get current time
        date = new Date();

        //set the comments
        commentsText = comments.getText().toString();

        //Generate a new record
        feel = mDrawableName.substring(0, 1).toUpperCase() + mDrawableName.substring(1);
        Record record = new Record(feel,resID,commentsText,date);
        MainActivity.recordHistory.add(record);
        saveData("record");
        Toast.makeText(this, R.string.save_toast, Toast.LENGTH_SHORT).show();
        finish();
    }

    public void initFromRecord(){

        //set another button to be invisible
        Button modify = findViewById(R.id.modifyButton);
        modify.setVisibility(View.INVISIBLE); //To set visible

        Button delete = findViewById(R.id.deleteButton);
        delete.setVisibility(View.INVISIBLE); //To set visible

        //set textview invisible in comment
        prompt.setVisibility(View.INVISIBLE);

        //set the comment edittext
        comments.setText(getIntent().getStringExtra("comment"));

        //set imageview
        res = getResources();
        mDrawableName = getIntent().getStringExtra("feeling");
        resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        drawable = res.getDrawable(resID);
        image.setImageDrawable(drawable );

        //set the textview
        prompt_text = titles.get(mDrawableName);
        prompt.setText(prompt_text);
        comments.setHint(prompt_text);
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
        prompt_text = getResources().getString(R.string.modify_delete_prompt);
        prompt.setText(prompt_text);

    }

    //save modified record to local file
    public void Modify(View v){

        String newComments  = comments.getText().toString();
        record.setComment(newComments);
        saveData("record");
        Toast.makeText(this, R.string.modify_toast, Toast.LENGTH_SHORT).show();
        finish();
    }

    //save record list to local file
    public void saveData(String key){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(MainActivity.recordHistory);
        editor.putString(key,json);
        editor.apply();
    }

    //delete a record
    public void Delete(View v){

        Object deleteRecord = MainActivity.recordHistory.remove(position);
        saveData("record");
        Toast.makeText(this, R.string.delete_toast, Toast.LENGTH_SHORT).show();
        finish();

    }

}
