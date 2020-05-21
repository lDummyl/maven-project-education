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
        List<Person>list = Secretary.getPersons();
        final int luckyChoice = new Random().nextInt(list.size());
        return list.get(luckyChoice);
    }
}