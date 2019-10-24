package task2;

import java.util.List;

public class Director {
    public Secretary chooseCandidate(List<Person> passed) {
        Secretary secretary;
        int canditateNumber = (int) (Math.random() * (passed.size()-1));
        secretary = new Secretary(passed.get(canditateNumber));
        return secretary;
    }
}
