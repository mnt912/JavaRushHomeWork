package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Administator on 23.09.2015.
 */
public class USD extends Money
{
    public String getCurrencyName()
    {
        return "USD";
    }

    public USD(double amount)
    {
        super(amount);
    }
}
