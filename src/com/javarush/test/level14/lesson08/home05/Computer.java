package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Administator on 22.09.2015.
 */
public class Computer
{
    Keyboard keyboard;
    Mouse mouse;
    Monitor monitor;

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}
