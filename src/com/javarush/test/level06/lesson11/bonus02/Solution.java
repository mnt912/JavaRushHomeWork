package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей


Cat name is дедушка Вася, no mother , no father
Cat name is бабушка Мурка, no mother , no father
Cat name is папа Котофей, no mother , father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

/*public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String gfName = reader.readLine();
        Cat gf = new Cat(gfName);

        String gmName = reader.readLine();
        Cat gm = new Cat(gmName);

        String fName = reader.readLine();
        Cat f = new Cat(fName,gf,null);

        String mName = reader.readLine();
        Cat m = new Cat(mName,null,gm);

        String sName = reader.readLine();
        Cat s = new Cat(sName,f,m);

        String dName = reader.readLine();
        Cat d = new Cat(dName,f,m);


        System.out.println(gf);
        System.out.println(gm);
        System.out.println(f);
        System.out.println(m);
        System.out.println(s);
        System.out.println(d);
    }

    public static class Cat
    {
        private String name;
        private Cat mother = null;
        private Cat father = null;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString()
        {
            String s = "Cat name is " + name;

            if (mother == null) s  += ", no mother ";
            else s += ", mother is " + mother.name;

            if (father == null) s  += ", no father ";
            else s += ", father is " + father.name;

            return s;
        }
    }

}*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName = reader.readLine();
        Cat catGrandpa = new Cat(grandpaName);

        String grandmaName = reader.readLine();
        Cat catGrandma = new Cat(grandmaName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, catGrandpa, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catGrandma);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFather, catMother);

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catDaughter);
        System.out.println(catSon);
    }

    public static class Cat
    {
        private String name;
        private Cat parentF;
        private Cat parentM;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parentF, Cat parentM)
        {
            this.name = name;
            this.parentF = parentF;
            this.parentM = parentM;
        }

        @Override
        public String toString()
        {
            String s="Cat name is " + name + ", ";
            if (parentM == null)
                s += "no mother, ";
            else
                s += "mother is " + parentM.name + ", ";
            if (parentF == null)
                s += "no father";
            else
                s += "father is " + parentF.name;
            return s;
        }
    }

}
