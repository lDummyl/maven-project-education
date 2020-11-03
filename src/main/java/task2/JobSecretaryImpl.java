package task2;

import task1.BirthDate;
import task1.Person;

public class JobSecretaryImpl extends Person implements Secretary {


    public JobSecretaryImpl(String name, BirthDate localbirthDate) {
        super(name, localbirthDate);
    }

    @Override
    public void sayHelloTo(Object o) {

    }
}
