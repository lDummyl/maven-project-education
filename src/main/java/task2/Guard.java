package task2;

import task1.Person;

import java.util.Random;

public class Guard extends Worker {
    Integer stressTolerance;
    public static final int maximumStressTolerance = 100;

    public Guard(Person person) {
        super(person);
        Random random = new Random();
        this.stressTolerance = random.nextInt(maximumStressTolerance);
    }

    public int compareTo(Guard o) {
        return this.stressTolerance.compareTo(o.stressTolerance) * 2 + (Integer.compare(this.age.getYears(), o.age.getYears())) + this.experience.compareTo(o.experience) * 3;
    }

}
