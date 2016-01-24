package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        TreeMap<String, Double> map = new TreeMap<String, Double>();

        double max = 0.0;
        while(reader.ready())
        {
            String s = reader.readLine();
            String []a = s.split(" ");

            double d = Double.parseDouble(a[1]);

            if (map.containsKey(a[0])) d += map.get(a[0]);

            if (d > max) max = d;

            map.put(a[0], d);
        }

        reader.close();

        for (String s : map.keySet())
        {
            if (map.get(s) == max) System.out.println(s);
        }
    }
}
