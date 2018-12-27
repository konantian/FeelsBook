package com.example.wangyuan.feelsbook;

import com.example.wangyuan.feelsbook.Model.Emotion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EmotionUnitTest {

    private Emotion emotion = new Emotion(3,"Joy");

    @Test
    public void emotionEqualTest(){

        assertEquals(3,emotion.getResId());
        assertEquals("Joy",emotion.getFeeling());
    }

    @Test
    public void emotionUnEqualTest(){

        assertNotEquals(4,emotion.getResId());
        assertNotEquals("joy",emotion.getFeeling());
    }

}
