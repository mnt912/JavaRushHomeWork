package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution
{
    public static void main(String[] args)
    {
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        List<File> fileList = new ArrayList<>();

        Queue<File> queue = new ArrayDeque<>();
        queue.add(new File(path));

        while(!queue.isEmpty())
        {
            for (File file : queue.peek().listFiles())
            {
                if (file.isDirectory()) queue.add(file);
                else
                {
                    if (file.length() > 50) file.delete();
                    else fileList.add(file);
                }
            }

            queue.poll();
        }

        if (fileList.size() > 0)
        {
            Collections.sort(fileList, new Comparator<File>()
            {
                @Override
                public int compare(File o1, File o2)
                {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            File resultFile = new File(resultFileAbsolutePath);
            File newResultFile = new File(resultFile.getParent() + "/allFilesContent.txt");

            resultFile.renameTo(newResultFile);

            try
            {
                FileWriter fileWriter = new FileWriter(newResultFile);

                for (int i = 0; i < fileList.size(); i++)
                {
                    FileReader fileReader = new FileReader(fileList.get(i));

                    while (fileReader.ready())
                    {
                        int c = fileReader.read();
                        fileWriter.write(c);
                    }

                    if (i != fileList.size() - 1) fileWriter.write('\n');
                    fileWriter.flush();

                    fileReader.close();
                }
            }
            catch (Exception e) {}
        }

        queue.add(new File(path));
        while(!queue.isEmpty())
        {
            for (File file : queue.peek().listFiles())
            {
                if (file.isDirectory())
                    if (file.list().length == 0) file.delete();
                    else fileList.add(file);
            }

            queue.poll();
        }
    }
}
