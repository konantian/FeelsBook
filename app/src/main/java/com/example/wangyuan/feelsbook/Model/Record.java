package com.example.wangyuan.feelsbook.Model;

public class Record {
    public String comment;
    public String date;
    public String feel;
    public int resId;


    public Record(String feel, int resId,String comment,String date) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
