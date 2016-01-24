package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();

        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) a[i] = i;
        list.add(a);

        a = new int[2];
        for (int i = 0; i < a.length; i++) a[i] = i;
        list.add(a);

        a = new int[4];
        for (int i = 0; i < a.length; i++) a[i] = i;
        list.add(a);

        a = new int[7];
        for (int i = 0; i < a.length; i++) a[i] = i;
        list.add(a);

        a = new int[0];
        list.add(a);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
