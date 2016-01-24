package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    private Solution()
    {}

    private Solution(int i)
    {}

    private Solution(char c)
    {}


    public Solution(double d)
    {}

    public Solution(float i)
    {}

    public Solution(long c)
    {}


    protected Solution(boolean b)
    {}

    protected Solution(byte b)
    {}

    protected Solution(Object o)
    {}


    Solution(Integer i)
    {}

    Solution(Float i)
    {}

    Solution(Double c)
    {}
}

