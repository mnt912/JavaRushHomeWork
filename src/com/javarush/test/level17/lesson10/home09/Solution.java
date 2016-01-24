package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String fileName1 = r.readLine();
            String fileName2 = r.readLine();

            Scanner sc = new Scanner(new FileInputStream(fileName1));
            while (sc.hasNextLine())
            {
                allLines.add(sc.nextLine());
            }

            sc = new Scanner(new FileInputStream(fileName2));
            while (sc.hasNextLine())
            {
                forRemoveLines.add(sc.nextLine());
            }
        }
        catch (Exception e) {}

        try
        {
            new Solution().joinData();
        }
        catch (CorruptedDataException e) { }
    }

    public  void joinData() throws CorruptedDataException
    {
        boolean f = false;

        for (String s : forRemoveLines)
        {
            if (allLines.contains(s)) allLines.remove(s);
            else
            {
                f = true;
                break;
            }
        }

        if (!f) return;

        allLines.clear();
        throw new CorruptedDataException();
    }
}
