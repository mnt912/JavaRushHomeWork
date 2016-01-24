package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileWriter stream = new FileWriter(r.readLine());

        while(true)
        {
            String s = r.readLine();
            stream.write(s + System.lineSeparator());
            if (s.equals("exit")) break;
        }

        r.close();
        stream.close();
    }
}
