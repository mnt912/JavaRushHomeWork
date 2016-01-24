package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Administator on 01.11.2015.
 */
public final class CurrencyManipulatorFactory
{
    private static HashMap<String, CurrencyManipulator> manipulators = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (manipulators.containsKey(currencyCode)) return manipulators.get(currencyCode);
        else
        {
            CurrencyManipulator  currencyManipulator = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode,currencyManipulator);
            return currencyManipulator;
        }
    }

    private CurrencyManipulatorFactory()
    {

    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return manipulators.values();
    }
}
