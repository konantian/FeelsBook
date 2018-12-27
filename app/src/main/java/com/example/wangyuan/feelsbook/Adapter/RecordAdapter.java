package com.example.wangyuan.feelsbook.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangyuan.feelsbook.Model.Emotion;
import com.example.wangyuan.feelsbook.R;

import java.util.List;

public class RecordAdapter extends ArrayAdapter<Emotion> {

    private int resourceId;
    private List<Emotion> emotions;

    public RecordAdapter(@NonNull Context context, int resource, List<Emotion> emotions) {
        super(context, resource, emotions);
        resourceId = resource;
        this.emotions = emotions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView emojiName = view.findViewById(R.id.emoji_name);
        ImageView emojiPic = view.findViewById(R.id.emoji_picture);

        Emotion emotion = emotions.get(position);
        emojiName.setText(emotion.feeling);
        emojiPic.setImageResource(emotion.resId);

        return view;
    }
}
