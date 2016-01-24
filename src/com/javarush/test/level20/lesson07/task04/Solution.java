package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные на сегодняшний день данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("data.txt");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            Solution solution = new Solution(12);
            System.out.println(solution);
            out.writeObject(solution);
            out.close();

            Solution s = new Solution(4);
            System.out.println(s);
            s = (Solution)in.readObject();
            in.close();
            System.out.println(s);

            System.out.println(s.string.equals(solution.string));
        }
        catch(Exception e)
        {

        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature)
    {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString()
    {
        return this.string;
    }
}
