package task2;

import task1.Person;

public class Lawyer extends Worker {

    public Lawyer(Person person) {
        super(person);
    }

    @Override
    public boolean passInterview() {
        return false;
    }

}
