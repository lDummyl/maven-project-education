package task2;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Director implements SecondTypeOfDirector {

    // TODO: 5/22/20 не и спользуй статические методы
    public static Person firstFinalChoose() {
        List<Person> list = new Secretary(null,null).getPersons();
        final int luckyChoice = new Random().nextInt(list.size());
        return list.get(luckyChoice);
    }

    @Override
    public Person secondFinalChoose() {
        int choice = 0;
//        System.out.println("Director 2: Hmmm... Lets make the second choice!/n Who are the most experienced?");
        Map<Integer, Person> map = changeExperience();
        for (Map.Entry<Integer, Person> personEntry : map.entrySet()) {
            if (choice < personEntry.getKey()) {
                choice = personEntry.getKey();
            }
//            System.out.printf("Experience %d years, name %s\n", personEntry.getKey(), personEntry.getValue());
        }
//        System.out.println("Most experience is " + choice + " years");
        return map.get(choice);
    }
}
