package task2;

import task1.BirthDate;
import task1.Person;

public class JobSecretary extends Person implements Secretary {


    public JobSecretary(String name, BirthDate localbirthDate) {
        super(name, localbirthDate);
    }

    @Override
    public void sayHelloTo(Object o) {

    }
}
