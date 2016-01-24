package com.javarush.test;

public class MainClass {

    public static void main(String[] args) {
        try {
            int sum = getSum();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getSum() {
        int n = 100;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }
}

