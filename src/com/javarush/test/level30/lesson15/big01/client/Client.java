package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Дмитрий on 11.11.2015.
 */
public class Client
{
    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("User '%s' connected to our chat!", userName));
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("User '%s' left our chat!", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) { Client.this.notify(); }
        }

        protected void clientHandshake() throws IOException,
                ClassNotFoundException
        {
            while (true)
            {
                Message message = Client.this.connection.receive();
                switch (message.getType())
                {
                    case NAME_REQUEST :
                        Client.this.connection.send(new Message(MessageType.USER_NAME, Client.this.getUserName()));
                        break;

                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;

                    default: throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException,
                ClassNotFoundException
        {
            while (true)
            {
                Message message = Client.this.connection.receive();
                switch (message.getType())
                {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;

                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;

                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;

                    default: throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run()
        {
            try
            {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (Exception e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Enter server address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Enter server port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Enter user name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            connection.send(new Message(MessageType.TEXT,text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Error!");
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this)
        {
            try { this.wait(); }
            catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error!");
                return;
            }
        }

        if (clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else { ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента."); return; }

        while (true)
        {
            String text = ConsoleHelper.readString();
            if (text.equalsIgnoreCase("exit")) break;
            if (shouldSentTextFromConsole())
            {
                sendTextMessage(text);
            }
        }

    }

    public static void main(String[] args)
    {
        new Client().run();
    }
}
