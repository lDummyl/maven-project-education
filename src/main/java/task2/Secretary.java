package task2;

import java.util.Random;

public class Secretary extends Employee {


    public Secretary(String name) {
        super(name);
    }

    public Coffee getCoffee(String sort) {
        return new Coffee(sort);
    }

    @Override
    public Boolean passInterview() {
        return true;
    }

    @Override
    public Boolean makeDecision() {
        Random random = new Random();
        boolean agree = random.nextBoolean();
        if (agree && random.nextBoolean()) super.setOfficeImHiredIn(null); //side effect
        return agree;
    }


}
