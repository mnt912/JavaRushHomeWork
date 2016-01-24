package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<String> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        HashMap <String, Cat> map = new HashMap<String, Cat>();

        map.put("Sim", new Cat("Sim"));
        map.put("Tom", new Cat("Tom"));
        map.put("Arbus", new Cat("Arbus"));
        map.put("Baby", new Cat("Baby"));
        map.put("Cat", new Cat("Sim"));
        map.put("Dog", new Cat("Dog"));
        map.put("Eat", new Cat("Eat"));
        map.put("Food", new Cat("Food"));
        map.put("Gevey", new Cat("Gevey"));
        map.put("Hugs", new Cat("Hugs"));

        return map;
    }

    public static Set<String> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        return  map.keySet();
    }

    public static void printCatSet(Set<String> set)
    {
        for (String cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
