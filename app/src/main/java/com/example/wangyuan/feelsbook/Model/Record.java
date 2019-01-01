package com.example.wangyuan.feelsbook.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Record {
    public String comment;
    public Date date;
    public String feel;
    public int resId;
    public String title;


    public Record(String title,String feel, int resId,String comment,Date date) {
        this.title = title;
        this.comment = comment;
        this.date = date;
        this.feel = feel;
        this.resId = resId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public int getResIdId() {
        return resId;
    }

    public void setResIdId(int resId) {
        this.resId = resId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getRecordTitle(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'-'HH:mm-EEEE", Locale.getDefault());
        String current_time = dateFormat.format(this.date);

        return "Date: "+current_time;
    }

}
