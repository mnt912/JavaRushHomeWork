package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources


        for (Person p : PEOPLE)
        {
            System.out.println(p.getName() + " " + p.getBirthday());
        }

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            while(reader.ready())
            {
                String s = reader.readLine();
                String []a = s.split(" ");

                Date date
                        = new GregorianCalendar(Integer.parseInt(a[a.length - 1]), Integer.parseInt(a[a.length - 2]) - 1, Integer.parseInt(a[a.length - 3])).getTime();

                String name = "";
                for (int i = 0; i <= a.length-4; i++)
                    name += a[i] + " ";

                name = name.substring(0,name.length()-1);

                PEOPLE.add(new Person(name, date));
            }

            reader.close();
        }

        catch(Exception e)
        {

        }
    }

}
