package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова

        for (Pair pair : result)
        {
            System.out.println(pair);
        }
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
c:/data.txt
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<String> list = new ArrayList<>();

        reader = new BufferedReader(new FileReader(fileName));
        while(reader.ready())
        {
            String line = reader.readLine();
            String []words = line.split(" ");

            for (String s : words)
            {
                StringBuilder stringBuilder = new StringBuilder(s);
                stringBuilder.reverse();
                if (list.contains(stringBuilder.toString()))
                {
                    Pair pair = new Pair();
                    pair.first = stringBuilder.toString();
                    pair.second = s;
                    result.add(pair);
                }
                else
                {
                    list.add(s);
                }
            }
        }

        reader.close();

    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString()
        {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
