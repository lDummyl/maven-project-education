package bonus;

import java.util.Arrays;

import java.util.List;


public class LambdaHW2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(-2, 2, -1, 5, 12, -4, 11);
        Calculation2 operation = (a, b) -> a + b;
        int sumOfEvenNumbers = getOperationResultOfEvenNumbers(integers, operation); //находим сумму четных чисел
        int sumOfPrimes = getOperationResultOfPrimes(integers, operation);     //находим сумму простых чисел
        System.out.println("Сумма четных чисел коллекции: " + sumOfEvenNumbers);
        System.out.println("Сумма простых чисел коллекции: " + sumOfPrimes);

        int multiplication = getOperationResultOfEvenNumbers(integers, (a, b) -> a * b); //находим произведение четных
        int multiplicationOfPrimes = getOperationResultOfPrimes(integers, (a, b) -> a * b);  //находим произведение простых
        System.out.println("Произведение четных чисел коллекции:" + multiplication);
        System.out.println("Произведение простых чисел коллекции: " + multiplicationOfPrimes);
    }

    private static int getOperationResultOfPrimes(List<Integer> integers, Calculation2 operation) {  // для простых чисел
        Integer result = null;

        for (Integer integer : integers) {
            if (isPrimeNumber(integer)) {
                if (result == null) {
                    result = integer;
                } else {
                    result = operation.calculate2(result, integer);
                }
            }
        }

        return result;
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

    private static int getOperationResultOfEvenNumbers(List<Integer> integers, Calculation2 operation) {  //для четных чисел
        //integers.removeIf(element -> element % 2 != 0);   // удалим нечетные элементы из коллекции
        Integer result = null;
        for (Integer integer : integers) {
            if (integer % 2 == 0) {
                if (result == null) {
                    result = integer;
                } else {
                    result = operation.calculate2(result, integer);
                }
            }
        }
        return result;
    }
}

@FunctionalInterface
interface Calculation2 {
    int calculate2(int a, int b);
}