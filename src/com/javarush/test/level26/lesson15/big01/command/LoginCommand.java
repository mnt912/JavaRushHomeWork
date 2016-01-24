package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Administator on 03.11.2015.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards
            = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String currentCard = ConsoleHelper.readString();
            String currentPin = ConsoleHelper.readString();

            if (validCreditCards.containsKey(currentCard))
            {
                if (validCreditCards.getString(currentCard).equals(currentPin))
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), currentCard));
                else
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),currentCard));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
            }
            else
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }

    }
}
