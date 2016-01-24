package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
c:\data.txt
c:\result.txt
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(r.readLine());
        FileWriter fileWriter = new FileWriter(r.readLine());

        while (fileReader.ready())
        {
            char c = (char)fileReader.read();
            if (c == '.') c = '!';
            fileWriter.write(c);
        }

        r.close();
        fileReader.close();
        fileWriter.close();
    }
}
