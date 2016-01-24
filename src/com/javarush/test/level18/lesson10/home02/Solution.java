package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String fileName = args[0];
        FileInputStream in = new FileInputStream(fileName);

        int count1 = in.available();
        int count2  = 0;
        while (in.available() > 0)
        {
            int b = in.read();
            if (b == 32) count2++;
        }

        double d = (double)count2/count1*100;
        BigDecimal b = new BigDecimal(d);
        b = b.setScale(2, BigDecimal.ROUND_HALF_UP);

        System.out.println(b);

        in.close();
    }
}
