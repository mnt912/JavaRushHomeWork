package com.javarush.test.level29.lesson15.big01.car;

/**
 * Created by Дмитрий on 08.11.2015.
 */
public class Truck extends Car
{
    public Truck(int numberOfPassengers)
    {
        super(Car.TRUCK, numberOfPassengers);
    }

    public int getMaxSpeed()
    {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
}
