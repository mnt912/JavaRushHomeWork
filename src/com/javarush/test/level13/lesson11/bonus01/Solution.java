package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        InputStream st = new FileInputStream(r.readLine());
        Scanner stream = new Scanner(st);


        ArrayList<Integer> list = new ArrayList<Integer>();

        while(stream.hasNextInt())
        {
            int i = stream.nextInt();
            if (i % 2 == 0) list.add(i);
        }

        Collections.sort(list);

        for (int i : list)
        {
            System.out.println(i);
        }

        r.close();
        stream.close();
    }
}
