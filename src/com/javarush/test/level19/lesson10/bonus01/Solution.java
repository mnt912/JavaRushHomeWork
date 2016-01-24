package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения

D:/file1.txt
D:/file2.txt

Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME

Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5

               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = console.readLine();
            String fileName2 = console.readLine();
            console.close();

            BufferedReader file1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
            BufferedReader file2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)));

            List<String> lines1 = new ArrayList<>();
            while (file1.ready()) {
                lines1.add(file1.readLine());
            }
            file1.close();

            List<String> lines2 = new ArrayList<>();
            while (file2.ready()) {
                lines2.add(file2.readLine());
            }
            file2.close();

            int index1, index2;
            for (index1 = 0, index2 = 0; index1 < lines1.size() && index2 < lines2.size(); ) {
                String line1 = lines1.get(index1);
                String line2 = lines2.get(index2);

                if (line1.equals(line2)) {
                    lines.add(new LineItem(Type.SAME, line1));
                    index1++;
                    index2++;
                }
                else {
                    if (!lines2.contains(line1)) {
                        lines.add(new LineItem(Type.REMOVED, line1));
                        index1++;
                    }
                    else {
                        lines.add(new LineItem(Type.ADDED, line2));
                        index2++;
                    }
                }
            }

            while (index1 < lines1.size()) {
                String line1 = lines1.get(index1);
                lines.add(new LineItem(Type.REMOVED, line1));
                index1++;
            }

            while (index2 < lines2.size()) {
                String line2 = lines2.get(index2);
                lines.add(new LineItem(Type.ADDED, line2));
                index2++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
