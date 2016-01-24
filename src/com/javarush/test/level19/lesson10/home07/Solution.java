package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        FileOutputStream out = new FileOutputStream(args[1]);

        String result = "";
        while (in.ready())
        {
            String line = in.readLine();
            String []lines = line.split(" ");

            for (String s : lines)
            {
                if (s.length() > 6) result += s + ",";
            }
        }

        result = result.substring(0, result.length()-1);
        out.write(result.getBytes());

        in.close();
        out.close();
    }
}
