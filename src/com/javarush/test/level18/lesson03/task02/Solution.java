package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f = new FileInputStream(r.readLine());
        int max = 256;

        while(f.available() > 0)
        {
            int i = f.read();
            if (i < max) max = i;
        }

        f.close();
        r.close();
        System.out.println(max);
    }
}
