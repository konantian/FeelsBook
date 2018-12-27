package com.example.wangyuan.feelsbook.Model;

import java.util.Date;

public class Record {
    private String comment;
    private Date data;
    private String feel;
    private int emojiId;


    public Record(String comment, Date data, String feel, int emojiId) {
        this.comment = comment;
        this.data = data;
        this.feel = feel;
        this.emojiId = emojiId;
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

    public int getEmojiId() {
        return emojiId;
    }

    public void setEmojiId(int emojiId) {
        this.emojiId = emojiId;
    }
}
