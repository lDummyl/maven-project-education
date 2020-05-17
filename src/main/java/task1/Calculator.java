package task1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Integer> list = new ArrayList<>();

        int a = 2;
        int b = 4;
        list.add(a);
        list.add(b);
        int sum = calculator.sum(list);
        System.out.println("sum = " + sum);

        System.out.println(calculator.divide(a, b));
        System.out.println(calculator.max(a,b));
//        Claculator.sum(a,b);
    }

    public int sum(int x, int y) {
        return x + y;
    }
    public int sum(List<Integer> list) {
        int sum=0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
    public int multiply(int x, int y) {
        return x * y;
    }
    public int multiply(List<Integer> list)
    {
        int multiply =1;
        for (Integer integer : list) {
            multiply *= integer;
        }
        return multiply;
    }

    public double divide(int x, int y) {
        return x / (y * 1.0);
    }
    public double divide(List<Integer> list)
    {
        int divide =1;
        for (Integer integer : list) {
            divide /= integer;
        }
        return divide;
    }
    public int min (int x, int y)
    {
        return x < y ? x : y;
    }
    public int max (int x, int y)
    {
        return Math.max(x, y);
    }

}
