package bonus;

import java.io.Serializable;
import java.util.ArrayList;

/* В качестве задания можно создать собственную иерархию "котиков" и имплементировать данные сценарии в рамках новых классов */

public class Generics {

    public static void main(String[] args) {
        covariant();
        contravariant();
    }

    private static void covariant() {
        /*Если производный тип контравариантен, (те ArrayList canAddOnlyNumbers контрвариантен классу Number) то для обеспечения безопасности контейнер должен быть write only.
         * В противном случае, остаётся возможность считывания объекта неверного класса*/
        ArrayList<Serializable> serializables = new ArrayList<>();
        serializables.add(3);
        serializables.add("1");
        serializables.add("Almost Any Thing");
        ArrayList<? super Number> canAddOnlyNumbers = serializables;
        {
            canAddOnlyNumbers.add(1); // can add
//not compile       canAddOnlyNumbers.add("1"); // but not this time
            //тем самым мы сужаем возможности записи в коллекцию в рамках этого scope
            canAddOnlyNumbers.add(3.14d); // can add
            canAddOnlyNumbers.add(1.9f); // can add
            canAddOnlyNumbers.add((short) 1); // can add
        }
//not compile        Serializable serializable = canAddOnlyNumbers.get(0); // compile error, cant determine what will I get, have to apply explicit cast.
        Object object = canAddOnlyNumbers.get(0); // only object is clear.
        for (Object someObject : canAddOnlyNumbers) {
            if (someObject instanceof Double) { // so we have to check every one of them
                System.out.println("My double is: " + someObject);
            }
        }
    }

    private static void contravariant() {
    /* Если производный тип ковариантен, (те ArrayList canReadNumbersOnly ковариантен классу Number)
     то для обеспечения безопасности контейнер должен быть read only.
    В противном случае, остаётся возможность записать в ArrayList<? extends Number> объект неверного типа
    */
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        ArrayList<Short> shorts = new ArrayList<>();
        shorts.add((short) 3);
        shorts.add((short) 5);
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(1.3d);
        doubles.add(4.3d);
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(1.3d);
        numbers.add((short)4);
        numbers.add(Integer.MAX_VALUE);
        numbers.add(1_000_000_000_000L);
        ArrayList<? extends Number> canReadNumbersOnly = integers;
        printAll(canReadNumbersOnly);
        canReadNumbersOnly = shorts;
        printAll(canReadNumbersOnly);
        printAll(doubles);
        printAll(numbers);
    }

    private static void printAll(ArrayList<? extends Number> canReadNumbersOnly) {
        double doubleSum = 0;
//not compile        canReadNumbersOnly.add(1_000_000); what if its short collection?
        for (Number number : canReadNumbersOnly) {
            doubleSum += number.doubleValue();
        }
        System.out.println("Double sum is " + doubleSum);
    }
}
