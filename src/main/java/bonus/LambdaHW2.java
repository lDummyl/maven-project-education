package bonus;

import java.util.Arrays;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;


public class LambdaHW2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(-2, 2, -1, 5, 12, -4, 11);
        BiFunction<Integer, Integer, Integer> operation = Integer::sum;
        int sumOfEvenNumbers = getOperationResultOfPrimes(integers, operation, LambdaHW2::isEvenNumber); //находим сумму четных чисел
        int sumOfPrimes = getOperationResultOfPrimes(integers, operation, LambdaHW2::isPrimeNumber);     //находим сумму простых чисел
        System.out.println("Сумма четных чисел коллекции: " + sumOfEvenNumbers);
        System.out.println("Сумма простых чисел коллекции: " + sumOfPrimes);

        int multiplication = getOperationResultOfPrimes(integers, (a, b) -> a * b, LambdaHW2::isEvenNumber); //находим произведение четных
        int multiplicationOfPrimes = getOperationResultOfPrimes(integers, (a, b) -> a * b, LambdaHW2::isPrimeNumber);  //находим произведение простых
        System.out.println("Произведение четных чисел коллекции:" + multiplication);
        System.out.println("Произведение простых чисел коллекции: " + multiplicationOfPrimes);

        int sumOfPrimes1 = getOperationResultOfPrimes(integers, operation, a -> true);     //находим сумму простых чисел
        System.out.println(sumOfPrimes1);
    }

    private static int getOperationResultOfPrimes(List<Integer> integers, BiFunction<Integer, Integer, Integer> operation, Predicate<Integer> operation2) {  // для простых чисел
        Integer result = null;

        for (Integer integer : integers) {
            if (operation2.test(integer)) {
                if (result == null) {
                    result = integer;
                } else {
                    result = operation.apply(result, integer);
                }
            }
        }

        return result;
    }

    // TODO: 3/9/20 как видишь параметры и возвращаемые значения этих методов   
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

    // TODO: 3/9/20 одинаковые, значит можно сказать что для них обоих сгодится один ф- интерфейс. 
    public static boolean isEvenNumber(int n) {  // метод для нахождения простых чисел
        return n % 2 == 0;
    }

    // TODO: 3/9/20 он позовлит тебе уйти от этой копипасты и объединить getOperationResultOfEvenNumbers  и getOperationResultOfPrimes если ты добавишь еще один функциональный аргумент, на манер Calculation2

}
