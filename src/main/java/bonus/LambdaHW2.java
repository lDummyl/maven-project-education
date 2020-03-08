package bonus;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LambdaHW2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 14, -4);
        Calculation2 operation = (a, b) -> a+b;
        getSumOfEvenNumbers(integers, operation);
    }

    private static void getSumOfEvenNumbers(List<Integer> integers, Calculation2 operation) {
       int result = 0;
        for (Integer integer : integers) {
            if (integer % 2 == 0){
                result = operation.calculate2(result, integer);
            }
        }
        System.out.println(result);
    }

}

@FunctionalInterface
interface Calculation2 {
    int calculate2(int a, int b);
}