package com.javarush.test.level32.lesson15.big01;

import java.io.File;

public class HTMLFileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        String filename = file.getName().toLowerCase();
        return (file.isDirectory() || (filename.endsWith(".html") || filename.endsWith(".htm")));
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
