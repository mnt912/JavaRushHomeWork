package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = r.readLine();
        String filename2 = r.readLine();

        FileInputStream inputStream = new FileInputStream(filename1);
        FileOutputStream outputStream = new FileOutputStream(filename2);

        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);

        for (int i = count-1; i >= 0; i--)
            outputStream.write(buffer[i]);

        inputStream.close();
        outputStream.close();
        r.close();
    }
}
