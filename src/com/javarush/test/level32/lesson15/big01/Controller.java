package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;


public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }


    public void init() {
        createNewDocument();
    }


    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }


    public void setPlainText(String text) {
        try {
            resetDocument();
            StringReader reader = new StringReader(text);
            new HTMLEditorKit().read(reader, document, 0);
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        try {
            StringWriter writer = new StringWriter();
            new HTMLEditorKit().write(writer,document, 0, document.getLength());
            return writer.toString();
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return null;
    }


    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        try {
            view.selectHtmlTab();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new HTMLFileFilter());

            int n = fileChooser.showOpenDialog(view);
            if (n == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                resetDocument();
                view.setTitle(currentFile.getName());
                FileReader reader = new FileReader(currentFile);
                new HTMLEditorKit().read(reader, document, 0);
                reader.close();
                view.resetUndo();
            }
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void saveDocument() {
        if (currentFile == null) saveDocumentAs();
        else {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());

        int n = fileChooser.showSaveDialog(view);
        if (n == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void exit() {
        System.exit(0);
    }


    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
