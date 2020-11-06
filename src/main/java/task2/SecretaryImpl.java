package task2;

import task1.Person;

public class SecretaryImpl extends Worker implements Secretary {
    public SecretaryImpl(Person person) {
        super(person);
    }

    @Override
    public void sayHelloTo(Object o) {
        System.out.println("Hi, i'm secretary");
    }
}