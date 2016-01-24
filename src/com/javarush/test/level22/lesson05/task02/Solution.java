package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null) throw new TooShortStringException();

        int i1 = string.indexOf("\t");
        int i2 = string.indexOf("\t",i1+1);

        if (i1 == -1 || i2 == -1) throw new TooShortStringException();

        return string.substring(i1+1,i2);
    }

    public static class TooShortStringException extends Exception
    {

    }

}
