package com.example.wangyuan.feelsbook;
import com.example.wangyuan.feelsbook.Model.Record;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordUnitTest {

    private Record record = new Record("Joy",3,"I feel happy today","2018-12-27");

    @Test
    public void recordEqualTest(){

        assertEquals("Joy",record.getFeel());
        assertEquals(3, record.getResIdId());
        assertEquals("I feel happy today", record.getComment());
        assertEquals("2018-12-27", record.getDate());

    }

    @Test
    public void recordUnEqualTest(){

        assertNotEquals("joy",record.getFeel());
        assertNotEquals(2, record.getResIdId());
        assertNotEquals("I feel sadness today", record.getComment());
        assertNotEquals("2018-12-28", record.getDate());

    }

}
