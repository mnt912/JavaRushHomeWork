package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception
    {
        //start here - начни тут
        String a1 = args[0];

        if (a1.equals("-c"))
        {
            String name = args[1];
            String sex = args[2];
            String bd = args[3];
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            if (sex.equals("м"))
            {
                allPeople.add(Person.createMale(name, date.parse(bd)));
            }
            else
            {
                allPeople.add(Person.createFemale(name, date.parse(bd)));
            }
            System.out.println(allPeople.size()-1);
        }
        else if (a1.equals("-u"))
        {
            int id = Integer.parseInt(args[1]);
            String name = args[2];
            String sex = args[3];
            String bd = args[4];
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            if (sex.equals("м"))
            {
                allPeople.set(id, Person.createMale(name, date.parse(bd)));
            }
            else
            {
                allPeople.set(id, Person.createFemale(name, date.parse(bd)));
            }
        }
        else if (a1.equals("-d"))
        {
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
        }
        else if (a1.equals("-i"))
        {
            int id = Integer.parseInt(args[1]);
            Person p = allPeople.get(id);
            String sex = p.getSex().equals(Sex.MALE) ? "м" : "ж";
            SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(p.getName() + " " + sex + " " + date.format(p.getBirthDay()));
        }
    }
}
