package task2;

import task1.BirthDate;
import task1.Name;
import task1.Person;

import java.util.Random;

public abstract class OfficeWorker extends Person {


    public OfficeWorker(Name name, BirthDate age) {
        super(name, age);
    }

    public boolean passInterview(){
        return new Random().nextBoolean();
    }


}
