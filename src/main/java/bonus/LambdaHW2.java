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
        int sumOfEvenNumbers = getSumOfEvenNumbers(integers, operation);
        System.out.println("sumOfEvenNumbers = " + sumOfEvenNumbers);
        int multiplication = getSumOfEvenNumbers(integers, (a, b) -> a * b);// TODO: 3/8/20 а если так, будет не сумма а произведение. Сделай метод более универсальным.
        System.out.println("multiplication = " + multiplication);
    }

    private static int getSumOfEvenNumbers(List<Integer> integers, Calculation2 operation) {
        int result = 0; // TODO: 3/8/20 чтобы сильно тебя не мучать, вот подсказка. Если лист не пустой, то инициализировать можно первым элементом.
        for (Integer integer : integers) {
            if (integer % 2 == 0){
                result = operation.calculate2(result, integer);
            }
        }
        return result;
    }

}

@FunctionalInterface
interface Calculation2 {
    int calculate2(int a, int b);
}