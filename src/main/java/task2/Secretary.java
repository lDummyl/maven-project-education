package task2;

import java.util.Random;

public class Secretary extends Employee {

    Random random = new Random();

    public Secretary(String name) {
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
        return "Secretary{" +
                "name=" + getName() +
                '}';
    }
}
