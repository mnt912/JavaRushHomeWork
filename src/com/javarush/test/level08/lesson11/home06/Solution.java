package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human c1 = new Human("c1", true, 5, new ArrayList<Human>());
        Human c2 = new Human("c2", false, 5, new ArrayList<Human>());
        Human c3 = new Human("c3", true, 5, new ArrayList<Human>());

        ArrayList<Human> children1 = new ArrayList<Human>();
        children1.add(c1);
        children1.add(c2);
        children1.add(c3);

        Human m = new Human("m", false, 50, children1);
        Human f = new Human("f", true, 50, children1);

        ArrayList<Human> children2 = new ArrayList<Human>();
        children2.add(f);

        ArrayList<Human> children3 = new ArrayList<Human>();
        children3.add(m);

        Human gf1 = new Human("gf1",true,90,children2);
        Human gm1 = new Human("gm1",false,90,children2);

        Human gf2 = new Human("gf2",true,90,children3);
        Human gm2 = new Human("gm2",false,90,children3);

        System.out.println(gf1);
        System.out.println(gf2);

        System.out.println(gm1);
        System.out.println(gm2);

        System.out.println(f);
        System.out.println(m);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
