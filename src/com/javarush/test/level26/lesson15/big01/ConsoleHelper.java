package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Administator on 01.11.2015.
 */
public class ConsoleHelper
{
    private static ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static void printExitMessage()
    {
        writeMessage(res.getString("the.end"));
    }

    public static String readString() throws InterruptOperationException
    {
        try
        {
            String s = reader.readLine();
            if (s.equalsIgnoreCase(res.getString("operation.EXIT"))) throw new InterruptOperationException();
            return s;
        }
        catch (IOException e)
        {
            return null;
        }
        catch (InterruptOperationException e)
        {
            throw e;
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String test;
        while (true)
        {
            test = readString();
            if (test.length() == 3)
                break;
            else
                writeMessage(res.getString("invalid.data"));

        }
        test = test.toUpperCase();
        return test;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] array;
        writeMessage(res.getString("choose.denomination.and.count.format"));

        while (true)
        {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (k <= 0 || l <= 0 || array.length != 2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        String s = readString();
        int i;

        try
        {
            i = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            writeMessage(res.getString("invalid.data"));
            return askOperation();
        }

        Operation operation;
        try
        {
           operation = Operation.getAllowableOperationByOrdinal(i);
        }
        catch (IllegalArgumentException e)
        {
            writeMessage(res.getString("invalid.data"));
            return askOperation();
        }

        return operation;
    }
}
