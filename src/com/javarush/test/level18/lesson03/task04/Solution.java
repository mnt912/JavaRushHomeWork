package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int []bytes = new int[256];
        int max = 10000;

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f = new FileInputStream(r.readLine());

        while (f.available() > 0)
        {
            int i = f.read();
            bytes[i]++;
            if (bytes[i] < max) max = bytes[i];
        }

        for (int i = 0; i < 255; i++)
        {
            if (bytes[i] == max) System.out.print(i + " ");
        }

        f.close();
        r.close();
    }
}
