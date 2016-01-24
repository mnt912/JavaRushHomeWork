package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administator on 01.11.2015.
 */
public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run()
    {
        int i = 1;
        while (true)
        {
            try
            {
                System.out.println("Some text for " + i++);
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                System.out.println(String.format("[%s] thread was terminated",Thread.currentThread().getName()));
                break;
            }
        }
    }
}
