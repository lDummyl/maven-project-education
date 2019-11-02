package task2;

import java.util.List;

public class Director {
    public Secretary chooseCandidate(List<Person> passed) {
        Secretary secretary;
        if (passed.size() == 0){
            return null;
        }
        if (passed.size()<2){
            secretary = new Secretary(passed.get(0));
            return secretary;
        } else {
            int candidateNumber = (int) (Math.random() * (passed.size()-1));
            secretary = new Secretary(passed.get(candidateNumber));
            return secretary;
        }
    }
}
