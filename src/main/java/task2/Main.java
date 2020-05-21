package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе


import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
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
        return secretaries;
    }


}

class Hr {

    Random random = new Random();
    final int sizeOfListHr;

    {
        sizeOfListHr = random.nextInt(Secretary.getPersons().size());
    }

    public List<Person> chooseSecretary() {
        List<Person> choosen = new ArrayList();
        for (int i = 0; i < Secretary.getPersons().size(); i++) {
            choosen.add(Secretary.getPersons().get(i));
            if (choosen.size() == sizeOfListHr) {
                break;
            }
        }
        return choosen;
    }


}

class Director {
    public static Person finalChoose() {
        List<Person>list = Secretary.getPersons();
        final int luckyChoice = new Random().nextInt(list.size());
        return list.get(luckyChoice);
    }
}