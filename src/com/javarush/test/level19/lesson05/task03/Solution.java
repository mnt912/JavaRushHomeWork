package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources
c:\data.txt
c:\result.txt
Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        FileReader reader = new FileReader(r.readLine());
        FileOutputStream out = new FileOutputStream(r.readLine());

        String w = "";
        int i;

        while ((i = reader.read()) != -1)
        {
            Character c = (char)i;

            if (!Character.isSpaceChar(c))
            {
                w += c;
            }

            if (Character.isSpaceChar(c) || !reader.ready())
            {
                try
                {
                    int j = Integer.parseInt(w);
                }
                catch(Exception e)
                {
                    w = "";
                    continue;
                }

                w += " ";
                out.write(w.getBytes());
                w = "";
            }
        }

        out.close();
        reader.close();
        r.close();
    }
}
