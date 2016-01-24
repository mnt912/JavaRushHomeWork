package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = r.readLine();
        String fileName2 = r.readLine();

        FileInputStream in1 = new FileInputStream(fileName1);
        FileInputStream in2 = new FileInputStream(fileName2);

        byte []b = new byte[in1.available()];
        in1.read(b);
        in1.close();

        FileOutputStream out = new FileOutputStream(fileName1);
        while (in2.available() > 0)
        {
            out.write(in2.read());
        }
        out.write(b);

        in2.close();
        out.close();
        r.close();
    }
}
