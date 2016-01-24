package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)  throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(r.readLine());
        FileOutputStream outputStream = new FileOutputStream(r.readLine());

        int i = 0;
        while (inputStream.available() > 0)
        {
            i++;
            int b = inputStream.read();
            if (i % 2 == 0) outputStream.write(b);
        }

        inputStream.close();
        outputStream.close();
        r.close();
    }
}
