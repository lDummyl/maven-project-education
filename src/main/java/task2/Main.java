package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе


import java.util.*;

public class Main {

}

class Secretary extends Person {

    public Secretary(Name name, BirthDate age) {
        super(name, age);

    }

    public static List<Person> getPersons() {
        List<Person> secretaries;
        secretaries = new ArrayList<>();
        for (int i = 0; i < Name.getNames().size(); i++) {
            secretaries.add(new Person(Name.getNames().get(i), BirthDate.getBirthDates().get(i)));
        }
        System.out.println("secretaries = " + secretaries.size());
        return secretaries;
    }


}

class Hr {

    public List<Person> chooseSecretary() {
        Random random = new Random();
        final int sizeOfListHr = random.nextInt(Secretary.getPersons().size());
        List <Person> choosen = new ArrayList();
        for (int i = 0; i < Secretary.getPersons().size(); i++) {
            choosen.add( Secretary.getPersons().get(i));
            if (choosen.size() == sizeOfListHr) {
                break;
            }
        }
        System.out.println("choosen = " + choosen.size());
        return choosen;
    }


}

class Director {
    public static Person finalChoose() {
        final int luckyChoice = new Random().nextInt(new Hr().chooseSecretary().size());
        System.out.println("luckyChoice = " + luckyChoice);
        return new Hr().chooseSecretary().get(luckyChoice);
    }
}