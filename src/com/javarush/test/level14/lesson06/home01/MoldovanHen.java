package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Administator on 22.09.2015.
 */
public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth() { return 3; }
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

