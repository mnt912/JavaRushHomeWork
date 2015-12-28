package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Дмитрий on 27.11.2015.
 */
public class CustomInvocationHandler implements InvocationHandler {

    private SomeInterfaceWithMethods someInterfaceWithMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.format("%s in" + System.lineSeparator(), method.getName());
        Object result = method.invoke(someInterfaceWithMethods, args);
        System.out.format("%s out"+ System.lineSeparator(), method.getName());
        return result;
    }
}

