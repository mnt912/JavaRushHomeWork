package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Administator on 23.09.2015.
 */
public class Hrivna extends Money
{
    public String getCurrencyName()
    {
        return "HRN";
    }

    public Hrivna(double amount)
    {
        super(amount);
    }
}
