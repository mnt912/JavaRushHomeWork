package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String filename = r.readLine();

        FileInputStream in = new FileInputStream(filename);

        int k = 0;

        while (in.available() > 0)
        {
            int b = in.read();
            if (b == 44) k++;
        }

        System.out.println(k);

        r.close();
        in.close();
    }
}
