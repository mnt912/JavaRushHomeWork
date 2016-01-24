package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String filename3 = r.readLine();

        FileInputStream in = new FileInputStream(filename1);
        FileOutputStream out1 = new FileOutputStream(filename2);
        FileOutputStream out2 = new FileOutputStream(filename3);

        int n = in.available();
        int k;
        if (n % 2 == 0) k = n / 2;
        else k = n / 2 + 1;

        for (int i = 0; i < k; i++)
        {
            int b = in.read();
            out1.write(b);
        }

        for (int i = 0; i < n/2; i++)
        {
            int b = in.read();
            out2.write(b);
        }

        r.close();
        in.close();
        out1.close();
        out2.close();
    }
}
