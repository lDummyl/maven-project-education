package bonus;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;



public class LambdaHomework {
    public static void main(String[] args) throws IOException {

        Calculation calculation1 = (a, b, c) -> a + 1 + b + 1 + c + 1;
        Calculation calculation2 = (a, b, c) -> a * 10 + b * 10 + c * 10;
        CalculationSmaller calculation3 = (a, b) -> a + b;

        int result1 = calculation1.calculate(1, 2, 3);
        int result2 = calculation2.calculate(1, 2, 3);
        List<Integer> integers = Arrays.asList(1, 2, 3);

        System.out.println(result1);
        System.out.println(result2);
        // TODO: 3/3/20 просто блеск, видно что много энергии, после отпуска такое бывает.

        int res = getCalculationOfAllOfThis(integers, calculation3);
        System.out.println("res = " + res);
        // TODO: 3/3/20 теперь задание, замени этот метод на функциональный интерфейс. И напиши 3 реализации
        //  1 чтобы проходил по всем элементам передаваемой коллекции(моя версия как есть)
        //  2 применял calculation только к четным ее элементам
        //  3 находил сумму/произведение/whatever всех простых чисел
        //  4 ... нуу это сложно, но если справишься точно Level Up будет! Находил максимальне число во всей коллекции. При этом не отступай от сигнатуры
        //  тот же контракт  int getCalculationOfAllOfThis(List<Integer> integers, CalculationSmaller calculation) тебе поможет https://proselyte.net/tutorials/java-core/collections-framework/comparator/
        //  calculation нужно сделать максимально близко к нему, вникнешь в святую троицу -1, +1 и 0,
        // TODO: 3/3/20 хотя вот что подумал там же можно проще сделать сравнением через больше\меншье, так что вот тебе еще задака


    }

    private static int getCalculationOfAllOfThis(List<Integer> integers, CalculationSmaller calculation) {
        int result = 0;
        for (Integer integer : integers) {
            result = calculation.calculate(result, integer);
        }
        return result;
    }
}

@FunctionalInterface
interface Calculation {
    int calculate(int a, int b, int c);
}

@FunctionalInterface
interface CalculationSmaller {
    int calculate(int a, int b);
}

// TODO: 3/3/20 напиши реализации этих интерфейсов и используй ех так чтобы они преобразовывали коллекцию Персон в коллекцию их имен и наоборот.

interface PersonProvider {
    String getName(Person pers);
}


class Person {

    Name name;

}

class Name {

    String name;

}