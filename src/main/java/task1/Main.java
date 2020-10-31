package task1;


import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        first();
        second();

    }

    public static void first() {
    }

    public static void second() {
        PersonsProvider generator = new PersonsProvider();
        // TODO: 9/10/20 сделай так чтобы все созданные 100к человек были уникальны
        // TODO: 9/12/20 увы незачет, следующая попытка...
        TreeSet<Person> setPerson = generator.generatePersons(100);
        //ArrayList<Human> list = new ArrayList<Human>();
        //list.addAll(setPerson);
        //generator.oldestSearchT(list);


       // for (Person p :
       //         setPerson) {
       //     System.out.println(p.getBirthDate().localBirthDate);
       // }

    }

}

