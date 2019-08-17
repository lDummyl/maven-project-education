package task2;

import java.util.Random;

public class Lawyer extends Employee {

    Random random = new Random();

    public Lawyer(String name) {
        super(name);
    }

    @Override
    public Boolean passInterview() {
        return true;
    }

    @Override
    public Boolean makeDecision() {
        boolean agree = random.nextBoolean();
        if (agree && random.nextBoolean())
            super.setOfficeImHiredIn(null); //side effect
        return agree;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "name=" + getName() +
                '}';
    }
}
