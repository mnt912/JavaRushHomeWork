package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Administator on 05.11.2015.
 */
public class MyThread extends Thread
{
    private static int number = 1;

    public MyThread()
    {
        setPriority(number);
        if (number < 10) number++;
        else number = 1;
    }

    public MyThread(Runnable target)
    {
        super(target);
        setPriority(number);
        if (number < 10) number++;
        else number = 1;
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);

        if (number <= group.getMaxPriority()) setPriority(number);
        else setPriority(group.getMaxPriority());

        if (number < 10) number++;
        else number = 1;
    }

    public MyThread(String name)
    {
        super(name);
        setPriority(number);
        if (number < 10) number++;
        else number = 1;
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);

        if (number <= group.getMaxPriority()) setPriority(number);
        else setPriority(group.getMaxPriority());

        if (number < 10) number++;
        else number = 1;
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPriority(number);
        if (number < 10) number++;
        else number = 1;
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);

        if (number <= group.getMaxPriority()) setPriority(number);
        else setPriority(group.getMaxPriority());

        if (number < 10) number++;
        else number = 1;
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);

        if (number <= group.getMaxPriority()) setPriority(number);
        else setPriority(group.getMaxPriority());

        if (number < 10) number++;
        else number = 1;
    }



}
