package com.example.wangyuan.feelsbook.Model;

public class Emotion {
    public String feeling;
    public int resId;

    public Emotion(int resId,String feeling) {
        this.resId = resId;
        this.feeling = feeling;
    }


    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
