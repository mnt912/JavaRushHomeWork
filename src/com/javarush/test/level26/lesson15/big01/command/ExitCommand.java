package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Administator on 01.11.2015.
 */
class ExitCommand implements Command
{
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");

    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        if (res.getString("yes").equals(ConsoleHelper.readString()))
            ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
}
