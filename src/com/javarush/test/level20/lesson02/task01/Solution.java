package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {

            //OutputStream outputStream = new FileOutputStream("c:/out.txt");
            InputStream inputStream = new FileInputStream("c:/out.txt");

           /* Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human ivan = new Human("Ivan", new Asset("home1"), new Asset("car1"));
            ivan.save(outputStream);
            outputStream.close();*/

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //somePerson.print();

            somePerson = new Human();
            somePerson.load(inputStream);
           // somePerson.print();

            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human
    {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human()
        {
        }

        public Human(String name, Asset... assets)
        {
            this.name = name;
            if (assets != null)
            {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintStream stream = new PrintStream(outputStream);

            stream.println(name);
            stream.println(assets.size());

            for (Asset asset : assets)
            {
                stream.println(asset.getName());
                stream.println(asset.getPrice());
            }
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            name = reader.readLine();

            int count = Integer.parseInt(reader.readLine());

            assets = new ArrayList<>();

            for (int i = 0; i < count; i++)
            {
                Asset a = new Asset(reader.readLine());
                a.setPrice(Double.parseDouble(reader.readLine()));
                assets.add(a);
            }
        }

        public void print()
        {
            System.out.println(name);
            for (Asset asset : assets)
            {
                System.out.println(asset.getName());
                System.out.println(asset.getPrice());
            }
        }
    }
}
