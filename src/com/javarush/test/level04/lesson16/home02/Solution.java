package com.javarush.test.level04.lesson16.home02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String s1 = r.readLine();
        String s2 = r.readLine();
        String s3 = r.readLine();

        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);

        if ( (i1 >= i2 && i1 <= i3) || (i1 >= i3 && i1 <= i2)) System.out.println(i1);
        if ( (i2 >= i1 && i2 <= i3) || (i2 >= i3 && i2 <= i1)) System.out.println(i2);
        if ( (i3 >= i2 && i3 <= i1) || (i3 >= i1 && i3 <= i2)) System.out.println(i3);
    }
}
