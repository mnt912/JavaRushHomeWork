package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        String zipFileName = args[1];

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        List<String> fileNames = new ArrayList<>();

        try (ZipOutputStream outputStream = new ZipOutputStream(byteArrayOutputStream)) {
            try (ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFileName))) {
                ZipEntry entry = inputStream.getNextEntry();
                while (entry != null) {
                    String s = entry.getName();
                    fileNames.add(s);
                    outputStream.putNextEntry(new ZipEntry(s));
                    copyData(inputStream, outputStream);

                    outputStream.closeEntry();
                    inputStream.closeEntry();

                    entry = inputStream.getNextEntry();
                }
            }
        }

        Path fileName = Paths.get(args[0]);

        try (ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
             ZipInputStream inputStream = new ZipInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
             FileInputStream fileInputStream = new FileInputStream(fileName.toString())) {

            if (fileNames.contains(args[0])) {
                outputStream.putNextEntry(new ZipEntry("new/" + fileName.getFileName().toString()));
                copyData(fileInputStream, outputStream);
                outputStream.closeEntry();
            }

            ZipEntry entry = inputStream.getNextEntry();
            while (entry != null) {
                outputStream.putNextEntry(new ZipEntry(entry.getName()));
                copyData(inputStream, outputStream);

                outputStream.closeEntry();
                inputStream.closeEntry();

                entry = inputStream.getNextEntry();
            }
        }
    }

    private static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
