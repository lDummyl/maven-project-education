package bonus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LambdaHomework {
    public static void main(String[] args) throws IOException {

        Calculation calculation1 = (a, b, c) -> a + 1 + b + 1 + c + 1;
        Calculation calculation2 = ((a, b, c) -> a * 10 + b * 10 + c * 10);
        BiFunction<Integer, Integer, Integer> calculation3 = (a, b) -> a + b;

        int result1 = calculation1.calculate(1, 2, 3);
        int result2 = calculation2.calculate(1, 2, 3);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        int res = getCalculationOfAllOfThis(integers, calculation3);

        System.out.println(result1);
        System.out.println(result2);
        // TODO: 3/3/20 просто блеск, видно что много энергии, после отпуска такое бывает.
        System.out.println("res = " + res);
        // TODO: 3/3/20 теперь задание, замени этот метод на функциональный интерфейс. И напиши 3 реализации
        //  1 чтобы проходил по всем элементам передаваемой коллекции(моя версия как есть)
        //  2 применял calculation только к четным ее элементам
        //  3 находил сумму/произведение/whatever всех простых чисел
        //  4 ... нуу это сложно, но если справишься точно Level Up будет! Находил максимальне число во всей коллекции. При этом не отступай от сигнатуры
        //  тот же контракт  int getCalculationOfAllOfThis(List<Integer> integers, CalculationSmaller calculation) тебе поможет https://proselyte.net/tutorials/java-core/collections-framework/comparator/
        //  calculation нужно сделать максимально близко к нему, вникнешь в святую троицу -1, +1 и 0,
        // TODO: 3/3/20 хотя вот что подумал там же можно проще сделать сравнением через больше\меншье, так что вот тебе еще задака

        System.out.println("max = " + integers.stream().max(Integer::compareTo).get());


        List<Person> persons = new ArrayList<>();
        List<String> names = new ArrayList<>();
        names.add("Ваня");
        names.add("Петя");

        Function<String, Person> personProvider = name -> {
            Name nameObj = new Name(name);
            Person personObj = new Person(nameObj);
            return personObj;
        };

        List<Person> people = names.stream().map(personProvider).collect(Collectors.toList());
        System.out.println(people);

        for (String name : names) {
            Person person;
            person = personProvider.apply(name);
            persons.add(person);
        }
        System.out.println(persons);

        Function<Person, String> nameProvider = pers -> pers.name.name;
        for (Person person : persons) {
            String name;
            name = nameProvider.apply(person);
            System.out.println(name);
        }

    }

    private static int getCalculationOfAllOfThis(List<Integer> integers, BiFunction<Integer,Integer,Integer> calculation3) {
        int result = 0;
        for (Integer integer : integers) {
            result = calculation3.apply(result, integer);
        }
        return result;
    }
}

@FunctionalInterface
interface Calculation {
    int calculate(int a, int b, int c);
}


// TODO: 3/3/20 напиши реализации этих интерфейсов и используй ех так чтобы они преобразовывали коллекцию Персон в коллекцию их имен и наоборот.



class Person {
    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                '}';
    }

    Name name;

    Person(Name name) {
        this.name = name;

    }

}

class Name {

    String name;

    Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}