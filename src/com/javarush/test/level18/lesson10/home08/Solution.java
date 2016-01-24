package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String s = r.readLine();
            if (s.equals("exit")) break;
            new ReadThread(s).start();
        }

        r.close();
    }

    public static class ReadThread extends Thread
    {
        String fileName;
        FileInputStream in;

        public ReadThread(String fileName)
        {
            //implement constructor body
            this.fileName = fileName;
            run();
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run()
        {
            try
            {
                FileInputStream in = new FileInputStream(fileName);
                int []bytes = new int[256];
                int max = 0;
                int max_i = 0;

                while(in.available() > 0)
                {
                    int i = in.read();
                    bytes[i]++;
                    if (bytes[i] > max)
                    {
                        max = bytes[i];
                        max_i = i;
                    }
                }

                resultMap.put(fileName, max_i);
            }

            catch(IOException e)
            {}
        }
    }
}
