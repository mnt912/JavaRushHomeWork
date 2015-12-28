package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String[] strings = new String[3];
        strings[0] = Helper.generateRandomString();
        strings[1] = Helper.generateRandomString();
        strings[2] = new String(strings[0]);

        Long[] ids = new Long[3];
        ids[0] = shortener.getId(strings[0]);
        ids[1] = shortener.getId(strings[1]);
        ids[2] = shortener.getId(strings[2]);

        Assert.assertNotEquals(ids[0], ids[1]);
        Assert.assertNotEquals(ids[2], ids[1]);
        Assert.assertEquals(ids[0], ids[2]);

        String[] newStrings = new String[3];
        newStrings[0] = shortener.getString(ids[0]);
        newStrings[1] = shortener.getString(ids[1]);
        newStrings[2] = shortener.getString(ids[2]);

        Assert.assertEquals(strings[0], newStrings[0]);
        Assert.assertEquals(strings[1], newStrings[1]);
        Assert.assertEquals(strings[2], newStrings[2]);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
