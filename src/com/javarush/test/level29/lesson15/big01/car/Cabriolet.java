package com.javarush.test.level29.lesson15.big01.car;

/**
 * Created by Дмитрий on 08.11.2015.
 */
public class Cabriolet extends Car
{
    public int getMaxSpeed()
    {
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }

    public Cabriolet(int numberOfPassengers)
    {
        super(Car.CABRIOLET, numberOfPassengers);
    }
}
