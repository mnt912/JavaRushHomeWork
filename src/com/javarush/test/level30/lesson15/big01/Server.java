package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Дмитрий on 10.11.2015.
 */
public class Server
{
    private static class Handler extends  Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            String userName = null;

            try(Connection connection = new Connection(socket))
            {
                ConsoleHelper.writeMessage("Connecting to port " + connection.getRemoteSocketAddress());
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            }
            catch (Exception e)
            {
                ConsoleHelper.writeMessage("Error!");
            }

            if (userName != null)
            {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            ConsoleHelper.writeMessage("Connection with server is closed");
        }

        private String serverHandshake(Connection connection) throws IOException,
                ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                if (message.getType().equals(MessageType.USER_NAME)
                        &&!message.getData().isEmpty()
                            && message.getData() != null
                                && !connectionMap.containsKey(message.getData()))
                {
                    connectionMap.put(message.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return message.getData();
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String, Connection> entry: connectionMap.entrySet())
            {
                if (entry.getKey().equals(userName)) continue;
                connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws
                IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                }
                else ConsoleHelper.writeMessage("Wrong message type!");
            }
        }
    }


    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        for (Map.Entry<String, Connection> entry: connectionMap.entrySet())
        {
            try
            {
                entry.getValue().send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage(String.format("Cannot send message for user '%'." + entry.getKey()));
            }
        }
    }

    public static void main(String[] args)
    {
        ServerSocket serverSocket;

        try
        {
            serverSocket = new ServerSocket(ConsoleHelper.readInt());
            ConsoleHelper.writeMessage("Server starts");

            while (true)
            {
                try
                {
                    Handler handler = new Handler(serverSocket.accept());
                    handler.start();
                }
                catch (Exception e)
                {
                    serverSocket.close();
                    throw new Exception();
                }
            }
        }

        catch (Exception e)
        {
            ConsoleHelper.writeMessage("Server error!");
        }
    }

}
