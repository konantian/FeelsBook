package com.example.wangyuan.feelsbook.Activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangyuan.feelsbook.Model.Record;
import com.example.wangyuan.feelsbook.R;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        String current_time = getIntent().getStringExtra("date");

        ImageView image= findViewById(R.id.displayEmoji);

        Resources res = getResources();
        String mDrawableName = getIntent().getStringExtra("feeling");;
        int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        image.setImageDrawable(drawable );

        TextView prompt = findViewById(R.id.feelPrompt);
        prompt.setText("It seems like you are feeling \""+mDrawableName+"\" today, do you wanna leave some comments?");

        EditText comments = findViewById(R.id.optionalComment);
        String commentsText = comments.getText().toString();

        Record record = new Record(mDrawableName,resID,commentsText,current_time);
    }
}
