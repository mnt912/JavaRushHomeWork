package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        for (int i = 0; i < 9; i++)
        {
            String s = "a" + i;
            map.put(s, new Date("JANUARY 1 2017"));
        }


        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();

        while (it.hasNext())
        {
            Map.Entry<String, Date> i = it.next();
            Date d = i.getValue();
            int month = d.getMonth();
            if (month >= 5 && month <= 7)
                it.remove();
        }
    }

}
