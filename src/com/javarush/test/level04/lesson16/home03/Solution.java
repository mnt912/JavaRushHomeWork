package com.javarush.test.level04.lesson16.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        int n = 0;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String s = r.readLine();
            int i = Integer.parseInt(s);
            n += i;
            if (i == -1)
            {
                System.out.println(n);
                break;
            }
        }

    }
}
