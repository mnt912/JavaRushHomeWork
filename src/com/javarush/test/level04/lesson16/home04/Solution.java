package com.javarush.test.level04.lesson16.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String name = r.readLine();

        String s1 = r.readLine();
        String s2 = r.readLine();
        String s3 = r.readLine();

        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);

        System.out.println("Меня зовут " + name);
        System.out.println("Я родился " + i3 + "." + i2 + "." + i1);
    }
}
