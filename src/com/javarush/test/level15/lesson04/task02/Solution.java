//package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

/*public class Solution
{
    public static void main(String[] args)
    {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) // 1
    {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, int value) // 2
    {
        System.out.println("Заполняем объектами int");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, double value) // 3
    {
        System.out.println("Заполняем объектами double");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, float value) // 4
    {
        System.out.println("Заполняем объектами float");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, long value) // 5
    {
        System.out.println("Заполняем объектами long");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, short value) // 6
    {
        System.out.println("Заполняем объектами short");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Float value) // 7
    {
        System.out.println("Заполняем объектами Float");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, char value) // 8
    {
        System.out.println("Заполняем объектами char");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Character value) // 9
    {
        System.out.println("Заполняем объектами Character");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, byte value) // 10
    {
        System.out.println("Заполняем объектами byte");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}*/

package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами.
В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
    /*1. метод******************/
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    /*2. метод******************/
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    /*3. метод******************/
    public static void printMatrix(double m, double n, String value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    /*4. метод******************/
    public static void printMatrix(Object m, Object n, String value) {
        System.out.println(m.getClass().getSimpleName());
        System.out.println(n.toString());
        System.out.println(Integer.parseInt(value));
    }

    /*5. метод******************/
    public static void printMatrix(Object m, Object n, Object value) {
        System.out.println(m.getClass().getSimpleName());
        System.out.println(n.toString());
        System.out.println(value.getClass().getSimpleName());
    }

    /*6. метод******************/
    public static void printMatrix(Object m, Integer n, String value) {
        System.out.println(m.getClass().getSimpleName());
        System.out.println(n.toString());
        System.out.println(Integer.parseInt(value));
    }

    /*7. метод******************/
    public static void printMatrix(Integer m, Object n, String value) {
        System.out.println(m.getClass().getSimpleName());
        System.out.println(n.toString());
        System.out.println(Integer.parseInt(value));
    }
    /*8. метод******************/
    public static void printMatrix(Object m, int n, String value) {
        System.out.println(m.getClass().getSimpleName());
        Integer c = n;
        System.out.println(c.byteValue());
        System.out.println(Integer.parseInt(value));
    }

    /*9. метод******************/
    public static void printMatrix(Integer m, Object n, Object value) {
        System.out.println(m.getClass().getSimpleName());
        System.out.println(n.toString());
        System.out.println(value.toString());
    }

    /*10. метод******************/
    public static void printMatrix(int m, Object n, String value) {
        int c = m;
        for (int i =0; i < c; i++){

        }
        System.out.println(n.toString());
        System.out.println(value.toString());
    }

}