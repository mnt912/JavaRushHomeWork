package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена

c:/data.txt
*/
public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        //...
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
               list.add(s);
            }
        }

        reader.close();

        String []words = new String[list.size()];
        StringBuilder result = getLine(list.toArray(words));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals("") || words.length == 1)
            return new StringBuilder(words[0]);

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        Collections.shuffle(list);

        StringBuilder result = new StringBuilder();

        if (isCorrectList(result,list)) return result;
        return getLine(words);
    }

    public static boolean isCorrectList(StringBuilder result, ArrayList<String> list)
    {
        result.append(list.get(0));
        for (int i = 1; i < list.size(); i++)
        {
            String s = list.get(i);
            if (result.substring(result.length() - 1).toLowerCase().equals(s.substring(0, 1).toLowerCase()))
                result.append(" " + s);
            else return false;
        }
        return true;
    }

}
