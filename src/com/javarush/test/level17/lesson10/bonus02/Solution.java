package com.javarush.test.level17.lesson10.bonus02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public  static  List<Person> allPeople = new ArrayList<Person>();
    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception
    {
        //start here - начни тут
        synchronized (Solution.class)
        {

            String a1 = args[0];

            if (a1.equals("-c"))
            {
                for (int i = 3; i < args.length; i += 3)
                {
                    String name = args[i - 2];
                    String sex = args[i - 1];
                    String bd = args[i];
                    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    if (sex.equals("м"))
                    {
                        allPeople.add(Person.createMale(name, date.parse(bd)));
                    } else
                    {
                        allPeople.add(Person.createFemale(name, date.parse(bd)));
                    }
                    System.out.println(allPeople.size() - 1);
                }

            }
            else if (a1.equals("-u"))
            {
                for (int i = 4; i < args.length; i += 4)
                {
                    int id = Integer.parseInt(args[i - 3]);
                    String name = args[i - 2];
                    String sex = args[i - 1];
                    String bd = args[i];
                    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    if (sex.equals("м"))
                    {
                        allPeople.set(id, Person.createMale(name, date.parse(bd)));
                    } else
                    {
                        allPeople.set(id, Person.createFemale(name, date.parse(bd)));
                    }
                }
            } else if (a1.equals("-d"))
            {
                for (int i = 1; i < args.length; i++)
                {
                    int id = Integer.parseInt(args[i]);
                    allPeople.get(id).setBirthDay(null);
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setSex(null);
                }
            }
            else if (a1.equals("-i"))
            {
                for (int i = 1; i < args.length; i++)
                {
                    int id = Integer.parseInt(args[i]);
                    Person p = allPeople.get(id);
                    String sex = p.getSex().equals(Sex.MALE) ? "м" : "ж";
                    SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.println(p.getName() + " " + sex + " " + date.format(p.getBirthDay()));
                }
            }
        }
    }
}
