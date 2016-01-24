package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream printStream = new PrintStream(System.out);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);

        testString.printSomething();

        String result = byteArrayOutputStream.toString();
        String[] lines = result.split(" ");

        int a = Integer.parseInt(lines[0]);
        int b = Integer.parseInt(lines[2]);

        Integer res = 0;
        if (lines[1].equals("+")) res = a + b;
        if (lines[1].equals("*")) res = a * b;
        if (lines[1].equals("-")) res = a - b;

        result = lines[0] + " " + lines[1] + " " + lines[2] + " = " + String.valueOf(res);

        System.setOut(printStream);

        System.out.println(result);
    }

    public static class TestString
    {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

