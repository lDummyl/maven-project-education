package bonus;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.Function;


/*Используя данную конструкцию, работая только в методе main вывести на печать
	ABC в строку и в столбик.
 */

public class Lambda {


    public static void main(String[] args) {


        // TODO: 10/26/20 доп. вывести CBA только 1 раз. Не важно как но не меняя кода нигде кроме лямбды. Задачка с подвохом так что думай out of the box.
        //  добавить дженерик в Funkey. Создать 3 новых интерфейса и методы TestDigits в нем коллекциями чисел. Через новые интрефейсы получить сумму,
        //  получить перевернутую колелекцию, только простые числа строкой через запятую.
        Funkey funHor = (System.out::print);
        Funkey funVert = (System.out::println);
        test(funHor);
        System.out.println(" ");
        test(funVert);

        Function<Collection<Number>, Number> funkeyNummerArrays = s -> {
            Double summ = 0.0;

            for (Number n : s) {
                summ += n.doubleValue();
            }
            return summ;
        };

        Function<Collection<Number>, String> funkeyToString = s -> {
            Double summ = 0.0;

            for (Number n : s) {
                summ += n.doubleValue();
            }
            return String.valueOf(summ);
        };

        FunkeyGen<Number, Collection<Number>> anon = new FunkeyGen<Number, Collection<Number>>() {
            @Override
            public Number action(Collection<Number> s) {
                Double summ = 0.0;

                for (Number n : s) {
                    summ += n.doubleValue();
                }
                return summ;
            }
        };

//        FunkeyGen middleNumberOfArray = s -> (funkeyNummerArrays.action(s)).doubleValue() / s.size();

        Function<String, Double> stringToDouble = Double::parseDouble;

        String s =  test2(funkeyToString);
        Number number =  test2(funkeyNummerArrays);
        //  test2(stringToDouble);

//        test2(middleNumberOfArray);


    }

    public static void test(List func) {

    }

    public static void test(Funkey func) {
        List<String> strings = Arrays.asList("A", "B", "C");
        for (String string : strings) {
            func.print(string);
        }
    }

    public static <T> T test2(Function<Collection<Number>, T> funkeyNummerArrays) {
        List<Number> numbers = Arrays.asList(1, 2, 3);
//        System.out.println(funkeyNummerArrays.apply(numbers));
        return funkeyNummerArrays.apply(numbers);
    }

}

@FunctionalInterface
interface Funkey {
    void print(String s);
}

interface FunkeyGen<Output, Input> {
    Output action(Input any);
}




