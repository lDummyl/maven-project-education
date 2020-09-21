package task1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;
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
        TreeSet<Person> setPerson = generator.generatePersons(10000);
        generator.oldestSearch(setPerson);
        //ArrayList<Person> list = new ArrayList<Person>();
        //list.addAll(setPerson);
        //generator.oldestSearchT(list);

    }

}

