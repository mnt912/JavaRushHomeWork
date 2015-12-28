package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Дмитрий on 11.11.2015.
 */
public class BotClient extends Client
{
    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);

            if (!message.contains(": ")) return;

            String a[] = message.split(": ");
            if (a.length != 2) return;

            SimpleDateFormat format;
            switch (a[1])
            {
                case "дата": format = new SimpleDateFormat("d.MM.YYYY"); break;
                case "день": format = new SimpleDateFormat("d"); break;
                case "месяц": format = new SimpleDateFormat("MMMM"); break;
                case "год": format = new SimpleDateFormat("YYYY"); break;
                case "время": format = new SimpleDateFormat("H:mm:ss"); break;
                case "час": format = new SimpleDateFormat("H"); break;
                case "минуты": format = new SimpleDateFormat("m"); break;
                case "секунды": format = new SimpleDateFormat("s"); break;
                default: return;
            }

            Date date = Calendar.getInstance().getTime();
            sendTextMessage("Информация для " + a[0] + ": " + format.format(date));
        }
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args)
    {
        new BotClient().run();
    }
}
