package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        //System.out.println(check(crossword, "home", 3, 5, -1, -1));
        List<Word> list = detectAllWords(crossword, "home", "same");
        for (Word word : list) {
            System.out.println(word.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();

        int lengthY = crossword.length;
        int lengthX = crossword[0].length;

        for (String word : words) {

            for (int y = 0; y < lengthY; y++)
                for (int x = 0; x < lengthX; x++) {

                    for (int dy = -1; dy <= 1; dy++)
                        for (int dx = -1; dx <= 1; dx++) {

                            Word w = check(crossword, word, y, x, dy, dx);
                            if (w != null) result.add(w);
                        }
                }
        }

        return result;
    }

    private static Word check(int[][] crossword, String word, int y, int x, int dy, int dx) {
        int cy = y;
        int cx = x;

        for (char c : word.toCharArray()) {
            try {
                if (crossword[cy][cx] == c) {
                    cy += dy;
                    cx += dx;
                }
                else throw new Exception();
            }
            catch (Exception e) {
                return null;
            }
        }

        Word w = new Word(word);
        w.setStartPoint(x, y);
        w.setEndPoint(cx - dx, cy - dy);

        return w;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
