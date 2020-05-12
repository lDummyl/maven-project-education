package task1;

import java.util.ArrayList;
import java.util.List;

public class Claculator {


    public static void main(String[] args) {
        Claculator claculator = new Claculator();
        List<Integer> list = new ArrayList<>();

        int a = 2;
        int b = 4;
        list.add(a);
        list.add(b);
        int sum = claculator.sum(list);
        System.out.println("sum = " + sum);

        System.out.println(claculator.divide(a, b));
//        Claculator.sum(a,b);
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

    public double divide(int x, int y) {
        return x / (y * 1.0);
    }

}
