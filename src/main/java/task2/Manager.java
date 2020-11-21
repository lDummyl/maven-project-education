package task2;

import task1.Person;

import java.util.Random;

public class Manager extends Worker {
    public Manager(Person person) {
        super(person);
    }

    @Override
    public boolean passInterview() {
        int neededScore = 50;
        int luck = 100;
        Random random = new Random();

       return ((this.experience + random.nextInt(luck) -this.age.getYears() ) > neededScore);
    }


}
