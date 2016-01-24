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
class DepositCommand implements Command
{
    private ResourceBundle res =
             ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String []a = ConsoleHelper.getValidTwoDigits(code);

        try
        {
            int i = Integer.parseInt(a[0]);
            int j = Integer.parseInt(a[1]);
            manipulator.addAmount(i, j);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), i*j, code));
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
