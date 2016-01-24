package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()
    {
        //implement this method - реализуйте этот метод
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            reader.close();
            load(inputStream);
        }
        catch (Exception e)
        {

        }
    }

    public void save(OutputStream outputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        PrintStream stream = new PrintStream(outputStream);
        Properties properties = new Properties();
        properties.putAll(this.properties);
        properties.store(outputStream, "");
        stream.close();
    }

    public void load(InputStream inputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();
        properties.load(inputStream);
        Enumeration enumeration = properties.propertyNames();

        while (enumeration.hasMoreElements())
        {
            String key = (String)enumeration.nextElement();
            this.properties.put(key, properties.getProperty(key));
        }
        inputStream.close();
    }
}
