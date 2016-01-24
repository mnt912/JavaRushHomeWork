package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        InputStream inStream = new FileInputStream(r.readLine());

        while(inStream.available() > 0)
        {
            System.out.print((char)inStream.read());
        }

        inStream.close();
        r.close();
    }
}
