package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.zip.DataFormatException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        exceptions.add(new FileNotFoundException());
        exceptions.add(new IOException());

        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new ConcurrentModificationException());

        exceptions.add(new RuntimeException());
        exceptions.add(new TooManyListenersException());

        exceptions.add(new ArrayStoreException());
        exceptions.add(new DataFormatException());

        exceptions.add(new NotYetBoundException());
    }
}
