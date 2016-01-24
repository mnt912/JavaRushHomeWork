package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Administator on 22.09.2015.
 */
public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth() { return 4; }
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
//return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.