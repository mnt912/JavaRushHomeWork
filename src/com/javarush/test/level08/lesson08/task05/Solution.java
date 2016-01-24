package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

/*public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        for (Map.Entry<String, String> pair: map.entrySet())
        {
            removeItemFromMapByValue(map, pair.getValue());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        int k = 1;
        String key = "";
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
            {
                if (k == 1)
                {
                    k++;
                    key = pair.getKey();
                }
                else
                {
                    map.remove(pair.getKey());
                    map.remove(key);
                }
            }

        }
    }
} */



public class Solution
{
    public static void main(String[] args){
        HashMap<String, String> map =   createMap();
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Afsd","Idf");
        map.put("Bfsd","Idertf");
        map.put("Cfsd","Idf");
        map.put("Dfsd","Isdfdf");
        map.put("Efsd","Idf");
        map.put("Ffsd","Ivcbdf");
        map.put("Gfsd","Idf");
        map.put("Hfsd","Ivcbdf");
        map.put("Ifsd","Idf");
        map.put("Tfsd","Idf");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        HashSet<String> list = new HashSet<String>();
        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();

        for(Map.Entry<String, String> s1 : map.entrySet()){
            int count = 0;
            for (Map.Entry<String, String> s2 : map.entrySet())
            {
                if (s1.getValue().equals(s2.getValue())) count++;
            }
            if(count > 1) list.add(iterator1.next().getKey());
        }
        for(String s : list){
            removeItemFromMapByValue(map,s);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        map.remove(value);
    }
}


