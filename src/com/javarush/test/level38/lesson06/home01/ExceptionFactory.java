package com.javarush.test.level38.lesson06.home01;

public class ExceptionFactory {

    public static Throwable getException(Enum e) {
        if (e != null) {
            String msg = e.name().substring(0,1).toUpperCase() + e.name().substring(1).toLowerCase().replaceAll("_", " ");
            if (e instanceof ExceptionApplicationMessage) {
                return new Exception(msg);
            }
            if (e instanceof ExceptionDBMessage) {
                return new RuntimeException(msg);
            }
            if (e instanceof ExceptionUserMessage) {
                return new Error(msg);
            }
        }
        return new IllegalArgumentException();
    }
}
