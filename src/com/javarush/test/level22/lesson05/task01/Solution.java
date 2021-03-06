package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution
{
    public static String getPartOfString(String string)
    {
        if (string == null) throw new TooShortStringException();
        String []s = string.split(" ");
        if (s.length < 5) throw new TooShortStringException();
        else return (s[1] + " " + s[2] + " " + s[3] + " " + s[4]);
    }

    public static class TooShortStringException extends RuntimeException
    {

    }

}
