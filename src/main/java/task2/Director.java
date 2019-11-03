package task2;

import java.util.List;
import java.util.Random;

public class Director {
    private Office office;
    private final int CANDIDATES_LIMIT = 5;
    public Secretary chooseCandidate(List<Person> passed) {
        Secretary secretary;
        if (passed.size() >= CANDIDATES_LIMIT) { // TODO: 11/3/19 это magic number, не очень приветствуется.
            int candidateNumber = new Random().nextInt(passed.size()-1);
            secretary = new Secretary(passed.get(candidateNumber));
            return secretary;
        }
        return office.getSecretary();
    }

    protected void setOffice(Office office) {
        this.office = office;
    }
}
