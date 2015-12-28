package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution
{
    public static List<String> getFileTree(String root) throws IOException
    {
        List <String> resultList = new ArrayList<>();
        Queue<File> queue = new ArrayDeque<>();
        queue.add(new File(root));

        while(!queue.isEmpty())
        {
            for (File file : queue.peek().listFiles())
            {
                if (file.isDirectory()) queue.add(file);
                else resultList.add(file.getAbsolutePath());
            }

            queue.poll();
        }

        return resultList;
    }
}
