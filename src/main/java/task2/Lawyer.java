package task2;

import task1.Person;

import java.util.Random;

public class Lawyer extends Worker {
    public static final int maxDeal = 500;
    int winDeal;

    public Lawyer(Person person) {
        super(person);
        Random random = new Random();
        this.winDeal = random.nextInt(maxDeal);
    }

    @Override
    public boolean passInterview() {
        int neededScore = 70;
        return ((this.experience + this.winDeal - this.getAge().getYears()) > neededScore);
    }

}
