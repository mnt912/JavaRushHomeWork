package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Дмитрий on 08.11.2015.
 */
public class Soldier extends  Human
{
    public void live()
    {
        fight();
    }

    public void fight()
    {
    }

    public Soldier(String name, int age)
    {
        super(name, age);
    }
}
