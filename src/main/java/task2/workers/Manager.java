package task2.workers;

import task1.Person;

import java.util.Random;

public class Manager extends Worker {
    int luck;

    public Manager(Person person) {
        super(person);
        Random random = new Random();
        this.luck = random.nextInt(100);
    }

    @Override
    public boolean passInterview() {
        int neededScore = 50;

        return ((this.experience + this.luck - this.getAge().getYears()) > neededScore);
    }
}
