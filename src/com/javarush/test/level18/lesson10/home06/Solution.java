package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        FileInputStream in = new FileInputStream(args[0]);
        int []chars = new int[256];

        while (in.available() > 0)
        {
            int i = in.read();
            chars[i]++;
        }

        for (int i = 0; i < 256; i++)
        {
            if (chars[i] != 0)
                System.out.println((char)i + " " + chars[i]);
        }

        in.close();
    }
}
