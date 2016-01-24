package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name = null;
        boolean sex = true; // true-male
        int age = 0;

        Human mother = null;
        Human father = null;

        String address = null;

        // 1
        public Human()
        {

        }

        // 2
        public Human(String name)
        {
            this.name = name;
        }

        // 3
        public Human(String name,boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

        // 4
        public Human(String name, int age, boolean sex, Human mother, Human father, String address)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
            this.address = address;
        }

        // 5
        public Human(String name, int age, boolean sex, Human mother, Human father)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }

        // 6
        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        // 7
        public Human(int age, boolean sex, Human mother, Human father, String address)
        {
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
            this.address = address;
        }

        // 8
        public Human(String name, int age, boolean sex, Human mother)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
        }

        // 9
        public Human(String name, int age, boolean sex, Human mother, String address)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.address = address;
        }

        // 10
        public Human(int age, boolean sex, Human mother, Human father)
        {
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }
    }
}
