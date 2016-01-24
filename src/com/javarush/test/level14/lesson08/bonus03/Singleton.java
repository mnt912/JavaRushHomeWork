package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Administator on 23.09.2015.
 */
public class Singleton
{
    static Singleton singleton = new Singleton();

    public static Singleton getInstance()
    {
        return singleton;
    }

    private Singleton()
    {

    }
}
