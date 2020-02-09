package task2;

import java.util.Random;

public class Secretary extends CompanyEmployee {

    @Override
    public String toString() {
        return "Secretary{" +
                "name='" + name + '\'' +
                '}';
    }

    public Secretary(String name) {
        super(name);
    }

    public void makeSomeCoffee(){
        System.out.println("Here is coffee");
    }


    @Override
    public boolean passInterview() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
