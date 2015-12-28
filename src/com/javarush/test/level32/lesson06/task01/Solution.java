package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte [] bytes = new byte[8];
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            byte b = 0;
            while (!( (b >= 48 && b <= 57) || (b >= 65 && b <= 90) || (b >= 97 && b <= 122) )) {
                b = (byte) (48 + random.nextInt(75));
            }
            bytes[i] = b;
        }

        bytes[0] = 'a';
        bytes[5] = 'A';
        bytes[7] = '9';

        try { out.write(bytes); }
        catch (Exception e) {}

        return out;
    }
}
