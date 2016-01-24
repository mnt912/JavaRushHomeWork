package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String url = r.readLine();
        String params = url.substring(url.indexOf("?") + 1, url.length());

        String val = null;

        while(true)
        {
            int i = params.indexOf("&");

            if (i == -1) i = params.length();
            String paramAndVal = params.substring(0, i);

            i = paramAndVal.indexOf("=");
            if (i == -1) i = paramAndVal.length();
            String param = paramAndVal.substring(0,i);

            if (param.equals("obj"))
            {
                val = paramAndVal.substring(paramAndVal.indexOf("=") + 1, paramAndVal.length());
            }

            System.out.print(param + " ");

            i = params.indexOf("&");
            if (i == -1) break;
            params = params.substring(i + 1, params.length());
        }

        System.out.println();

        if (val != null)
        {
            try
            {
                double d = Double.parseDouble(val);
                alert(d);
            }
            catch(Exception e)
            {
                alert(val);
            }
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
