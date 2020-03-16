package bonus;

import java.util.Arrays;
import java.util.List;

public class LambdaHW3 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(-2, 2, -1, 5, 12, -4, 11);
        //Суммы:
        int sumOfEvens = integers.stream().filter(a -> a % 2 == 0).reduce(0, (result, integer) -> result + integer);
        System.out.println(sumOfEvens);

        int sumOfPrimes = integers.stream().filter(a -> isPrimeNumber(a)).reduce(0, (result, integer) -> result + integer);
        System.out.println(sumOfPrimes);

        int multiOfEvens = integers.stream().filter(a -> a % 2 == 0).reduce(1, (result, integer) -> result * integer);
        System.out.println(multiOfEvens);

        int multiOfPrimes = integers.stream().filter(a -> isPrimeNumber(a)).reduce(1, (result, integer) -> result * integer);
        System.out.println(multiOfPrimes);

    }
    public static boolean isPrimeNumber(int n) {  // метод для нахождения простых чисел
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n <= 1)
                return false;
            if (n == 2)
                return true;
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        return (n % 2 != 0 && prime && n > 2) || n == 2;
    }

    @FunctionalInterface
    interface Calculation3 {
        boolean calculate3(int a);
    }
}
