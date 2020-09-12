package task1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        first();
        second();

    }

    public static void first() {
    }

    public static void second() {
        PersonsProcessor generator = new PersonsProcessor();
        // TODO: 9/10/20 сделай так чтобы все созданные 100к человек были уникальны
        // TODO: 9/12/20 увы незачет, следующая попытка...
        ArrayList<Person> list = (ArrayList<Person>) generator.generatePersons(100000).clone();
        System.out.println(list.size());
        System.out.println(Person.oldest.name.firstName);
    }

}

