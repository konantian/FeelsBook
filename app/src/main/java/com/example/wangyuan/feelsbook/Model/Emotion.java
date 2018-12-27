package com.example.wangyuan.feelsbook.Model;

public class Emotion {
    public String feeling;
    public int resId;

    public Emotion(int resId,String feeling) {
        this.resId = resId;
        this.feeling = feeling;
    }
}
