package task1;

import task2.Secretary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonProvider{

    static List<String> firstN = new ArrayList<>();
    static Random random = new Random();
    static List<String> lastN = new ArrayList<>();

    static {
        firstN.add("Ivan");
        firstN.add("Oleg");
        firstN.add("Nikita");
        firstN.add("Roman");
        firstN.add("Nikolay");
        firstN.add("Dmitry");
        firstN.add("Alexander");
        firstN.add("Stanislav");
        firstN.add("Konstantin");
        firstN.add("Sergey");
    }

    static {
        lastN.add("Ivanov");
        lastN.add("Smirnov");
        lastN.add("Sidorov");
        lastN.add("Petrov");
        lastN.add("Vodkin");
        lastN.add("Nikitin");
        lastN.add("Orlov");
        lastN.add("Kruglov");
        lastN.add("Jiglov");
        lastN.add("Djigurda");
    }

    public static List<String> getFirstN(){
        return firstN;
    }

    public static List<String> getLastN(){
        return lastN;
    }

    public Person getSomePerson() {
        return new Person(new Name(firstN.get(random.nextInt(firstN.size())), lastN.get(random.nextInt(lastN.size()))),
                new Age(random.nextInt(30) + 1, random.nextInt(12) + 1, random.nextInt(80) + 1940));
    }

    public List<Person> getSomePerson(int qty) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            list.add(getSomePerson());
        }
        return list;
    }
    public List<Secretary> getSomeSecretaries(int qty){
        List<Person> somePerson = getSomePerson(qty);
        for (Person person : somePerson) {
            new Secretary(person);
        }
    }


}
