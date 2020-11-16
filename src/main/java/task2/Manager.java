package task2;

import task1.Person;

public class Manager extends Worker {
    public Manager(Person person) {
        super(person);
    }

    @Override
    public boolean passInterview() {
        return false;
    }


}
