package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws DownloadException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();

        try
        {
            while (true)
            {

                String name = r.readLine();
                FileInputStream in = new FileInputStream(name);
                list.add(in);
                if (in.available() < 1000) break;
            }
        }
        catch(Exception e)
        {}

        try
        {
            for (FileInputStream in : list)
            {
                in.close();
            }
            r.close();
        }
        catch (Exception e)
        {}

        throw new DownloadException();
    }

    public static class DownloadException extends Exception
    {

    }
}
