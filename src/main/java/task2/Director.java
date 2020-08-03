package task2;

import java.util.List;
import java.util.Random;

public class Director {

    private Random randomChoose;

    public Secretary chooseSecretary(List<Secretary> secretaries) {
        randomChoose = new Random();
        return secretaries.get(randomChoose.nextInt(secretaries.size() - 1));
    }

}
