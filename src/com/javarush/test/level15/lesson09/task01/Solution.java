package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution
{
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(19.0,"a");
        labels.put(19.10,"b");
        labels.put(19.20,"c");
        labels.put(19.30,"d");
        labels.put(19.40,"e");
    }

    public static void main(String[] args)
    {
        System.out.println(labels);
    }
}
