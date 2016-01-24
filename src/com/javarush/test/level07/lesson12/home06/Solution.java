package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gf1 = new Human();
        gf1.name = "gf1";
        gf1.sex = true;
        gf1.age = 90;
        gf1.father = null;
        gf1.mother = null;
        System.out.println(gf1);

        Human gf2 = new Human();
        gf2.name = "gf2";
        gf2.sex = true;
        gf2.age = 90;
        gf2.father = null;
        gf2.mother = null;
        System.out.println(gf2);


        Human gm1 = new Human();
        gm1.name = "gm1";
        gm1.sex = false;
        gm1.age = 90;
        gm1.father = null;
        gm1.mother = null;
        System.out.println(gm1);

        Human gm2 = new Human();
        gm2.name = "gm2";
        gm2.sex = false;
        gm2.age = 90;
        gm2.father = null;
        gm2.mother = null;
        System.out.println(gm2);

        Human f = new Human();
        f.name = "f";
        f.sex = true;
        f.age = 30;
        f.father = gf1;
        f.mother = gm1;
        System.out.println(f);

        Human m = new Human();
        m.name = "m";
        m.sex = false;
        m.age = 20;
        m.father = gf2;
        m.mother = gm2;
        System.out.println(m);

        Human c1 = new Human();
        c1.name = "c1";
        c1.sex = true;
        c1.age = 3;
        c1.father = f;
        c1.mother = m;
        System.out.println(c1);

        Human c2 = new Human();
        c2.name = "c2";
        c2.sex = true;
        c2.age = 3;
        c2.father = f;
        c2.mother = m;
        System.out.println(c2);

        Human c3 = new Human();
        c3.name = "c3";
        c3.sex = true;
        c3.age = 3;
        c3.father = f;
        c3.mother = m;
        System.out.println(c3);
    }

    public static class Human
    {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
