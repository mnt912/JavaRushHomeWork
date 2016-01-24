package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Administator on 17.10.2015.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses= new ArrayList<Horse>();

    public static Hippodrome game;

    public static void main(String []args)
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Ahhj",3,0));
        game.getHorses().add(new Horse("Bfgh",3,0));
        game.getHorses().add(new Horse("Cgfh",3,0));
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void move()
    {
        for (Horse horse : horses)
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : horses)
        {
            horse.print();
        }

        System.out.println();
        System.out.println();
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            try  { Thread.sleep(200); }
            catch (InterruptedException e) {}
        }
    }

    public Horse getWinner()
    {
        double max_distance = 0;
        Horse winner = null;
        for (Horse horse : horses)
        {
            if (horse.getDistance() > max_distance)
            {
                max_distance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
