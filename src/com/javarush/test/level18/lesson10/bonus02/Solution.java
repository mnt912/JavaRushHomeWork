package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

c:/data.txt
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        int max_id = 0;
        while (in.ready())
        {
            int n_id = Integer.parseInt(in.readLine().substring(0, 8).trim());
            if (n_id > max_id) max_id = n_id;
        }
        in.close();

        max_id++;

        String result = "";
        int []lengths = {4, 30, 8, 4};
        args[0] = String.valueOf(max_id);
        for (int i = 0; i < args.length; i++)
        {
            result += args[i];
            for (int j = 0; j < (lengths[i]-args[i].length()); j++)
                result += " ";
        }

        System.out.println(result);

        FileOutputStream out = new FileOutputStream(fileName,true);
        out.write(result.getBytes());
        out.close();
    }
}
