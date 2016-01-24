package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Administator on 22.09.2015.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth() { return 1; }
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
