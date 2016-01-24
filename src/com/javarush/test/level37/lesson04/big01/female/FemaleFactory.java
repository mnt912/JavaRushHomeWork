package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

public class FemaleFactory implements AbstractFactory {

    public Human getPerson(int age) {
        Woman woman = new Woman();
        TeenGirl teenGirl = new TeenGirl();
        KidGirl kidGirl = new KidGirl();

        if (age <= kidGirl.MAX_AGE) return kidGirl;
        if (age <= teenGirl.MAX_AGE) return teenGirl;
        return woman;
    }
}
