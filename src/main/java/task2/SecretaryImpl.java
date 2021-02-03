package task2;

import task1.Person;

public class SecretaryImpl extends Worker implements Secretary {
    public SecretaryImpl(Person person) {
        super(person);
    }

    @Override
    public boolean passInterview() {
        int neededScore = 200;
        return ((this.experience - this.getAge().getYears() * 2) > neededScore);
    }

    @Override
    public void sayHelloTo(Object o) {
        System.out.println("Hi, i'm secretary");
    }
}