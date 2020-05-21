package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе


import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Director {
    public static Person finalChoose() {
        // TODO: 5/21/20 Secretry class не попал в репозиторий
        List<Person>list = Secretary.getPersons();
        final int luckyChoice = new Random().nextInt(list.size());
        return list.get(luckyChoice);
    }
}