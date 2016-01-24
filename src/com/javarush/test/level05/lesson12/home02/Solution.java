package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man m1 = new Man("a",18,"g");
        Man m2 = new Man("b",18,"h");
        Woman w1 = new Woman("a",18,"g");
        Woman w2 = new Woman("b",18,"h");

        //выведи их на экран тут
        System.out.println(m1.name + " " + m1.age + " " + m1.address);
        System.out.println(m2.name + " " + m2.age + " " + m2.address);
        System.out.println(w1.name + " " + w1.age + " " + w1.address);
        System.out.println(w2.name + " " + w2.age + " " + w2.address);
    }

    //добавьте тут ваши классы
    public static class Man
    {
        public String name;
        public String address;
        public int age;

        Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman
    {
        public String name;
        public String address;
        public int age;

        Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
