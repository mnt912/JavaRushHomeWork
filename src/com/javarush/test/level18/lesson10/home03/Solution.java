package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
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
        String fileName3 = r.readLine();

        FileOutputStream out = new FileOutputStream(fileName1);
        FileInputStream in1 = new FileInputStream(fileName2);
        FileInputStream in2 = new FileInputStream(fileName3);

        while (in1.available() > 0)
        {
            out.write(in1.read());
        }

        while (in2.available() > 0)
        {
            out.write(in2.read());
        }

        out.close();
        in1.close();
        in2.close();
        r.close();
    }
}
