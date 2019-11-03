package task2;

import java.util.List;
import java.util.Random;

public class Director {
    public Secretary chooseCandidate(List<Person> passed) {
        Secretary secretary;
        if (passed.size() >= 5) { // TODO: 11/3/19 это magic number, не очень приветствуется.
            int candidateNumber = new Random().nextInt(passed.size()-1);
            secretary = new Secretary(passed.get(candidateNumber));
            return secretary;
        }
        return null;
    }
}
