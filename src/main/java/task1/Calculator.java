package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Integer> list = Arrays.asList(2,4,5,6,2,8,9,1,-10,871,44,11,12);

        int a = 2;
        int b = 4;
        int c = 14;
        int sum = calculator.sum(list);
        System.out.println("sum = " + sum);

        System.out.println(calculator.min(list));
        System.out.println(calculator.max(list));
        System.out.println(calculator.pow(a,c));
        System.out.println(calculator.round(calculator.arithmeticMean(list)));

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
        return Math.min(x, y);
    }
    public int min (List <Integer> list)
    {
        int min = list.get(0);
        for (Integer integer : list) {
            if (min > integer)
            {
                min = integer;
            }
        }
        return min;
    }
    public int max (int x, int y)
    {
        return Math.max(x, y);
    }
    public int max (List<Integer> list)
    {
        int max = list.get(0);
        for (Integer integer : list) {
            if (max < integer)
            {
                max = integer;
            }
        }
        return max;
    }
    public double pow (double x, double y)
    {
        return Math.pow(x,y);
    }
    public double sqrt (double x)
    {
        return Math.sqrt(x);
    }
    public double cbrt (double x)
    {
        return Math.cbrt(x);
    }
    public double arithmeticMean (int x, int y)
    {
        return sum(x,y)/(2*1.0);
    }
    public double arithmeticMean (List<Integer> list)
    {
        return sum(list)/(list.size()*1.0);
    }
    public double round (double x)
    {
        return Math.round(x);
    }

}
