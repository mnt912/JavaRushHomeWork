package com.javarush.test.level35.lesson10.bonus01;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses/");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        try {
            Set<Animal> result = new HashSet<>();

            if (!(pathToAnimals.endsWith("/") || pathToAnimals.endsWith("\\"))) {
                pathToAnimals = pathToAnimals + "/";
            }

            File directory = new File(pathToAnimals);
            String[] classFiles = directory.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".class");
                }
            });


            final String path = pathToAnimals;

            ClassLoader loader = new ClassLoader() {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    try {
                        byte[] data = Files.readAllBytes(Paths.get(path + name));
                        return defineClass(null, data, 0, data.length);
                    } catch (Exception e) {
                        return null;
                    }
                }
            };

            for (String className : classFiles) {
                Class c = loader.loadClass(className);
                if (c != null) {
                    boolean hasInterface = false;
                    Class[] interfaces = c.getInterfaces();
                    for (Class i : interfaces) {
                        if (i.equals(Animal.class)) {
                            hasInterface = true;
                            break;
                        }
                    }
                    if (!hasInterface) continue;

                    Constructor[] constructors = c.getConstructors();
                    for (Constructor constructor : constructors) {
                        if (Modifier.isPublic(constructor.getModifiers()) &&
                                constructor.getParameterTypes().length==0) {
                            result.add((Animal)c.newInstance());
                            break;
                        }
                    }
                }
            }

            return result;
        }
        catch (Exception e) {
            return null;
        }
    }
}
