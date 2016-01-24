package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}

    public static void main(String []args)
    {
        String []result = getTokens("level22.lesson13.task01", ".");
    }
*/
public class Solution
{
    public static String [] getTokens(String query, String delimiter)
    {
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer s = new StringTokenizer(query,delimiter);
        while(s.hasMoreTokens())
        {
            list.add(s.nextToken());
        }
        String []result = new String[list.size()];
        return list.toArray(result);
    }
}
