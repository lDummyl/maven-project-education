package task2.NewOffice;

import task1.Person;


import java.util.Random;

public abstract class OfficeWorker implements ApplyingForAJob {

    Person person;

    public Person getPerson() {
        return person;
    }

    @Override
    public boolean passAnInterview() {
        return new Random().nextBoolean();
    }


}
