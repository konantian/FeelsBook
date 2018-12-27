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

import com.example.wangyuan.feelsbook.Model.Record;
import com.example.wangyuan.feelsbook.R;

import java.util.List;

public class HistoryAdapter extends ArrayAdapter<Record> {

    private int resourceId;
    private List<Record> records;

    public HistoryAdapter(@NonNull Context context, int resource, List<Record> records) {
        super(context, resource, records);
        resourceId = resource;
        this.records = records;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView emojiName = view.findViewById(R.id.contentHistory);
        ImageView emojiPic = view.findViewById(R.id.emojiHistory);

        Record record  = records.get(position);
        String date = record.getDate();
        String comments  = record.getComment();
        String feel = record.getFeel();

        emojiName.setText(date+"  "+feel+"\n"+comments);
        emojiPic.setImageResource(record.emojiId);

        return view;
    }
}
