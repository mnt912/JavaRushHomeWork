package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

public class MaleFactory implements AbstractFactory {

    public Human getPerson(int age) {
        Man man = new Man();
        TeenBoy teenBoy = new TeenBoy();
        KidBoy kidBoy = new KidBoy();

        if (age <= kidBoy.MAX_AGE) return kidBoy;
        if (age <= teenBoy.MAX_AGE) return teenBoy;
        return man;
    }
}
