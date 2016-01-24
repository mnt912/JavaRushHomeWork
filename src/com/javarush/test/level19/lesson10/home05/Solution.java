package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
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

        while (in.ready())
        {
            String s = in.readLine();
            String []a = s.split(" ");

            for (int i = 0; i < a.length; i++)
            {
                String b = a[i].replaceFirst("\\d","");
                if (b.length() != a[i].length()) out.write((a[i]+ " ").getBytes());
            }
        }

        in.close();
        out.close();
    }
}
