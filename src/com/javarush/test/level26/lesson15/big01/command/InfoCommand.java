package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Administator on 01.11.2015.
 */
class InfoCommand implements Command
{
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        boolean b = false;

        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (manipulator.hasMoney()) {
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - "
                        + Integer.valueOf(manipulator.getTotalAmount()).toString()); b = true; }
        }

        if (!b) ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
