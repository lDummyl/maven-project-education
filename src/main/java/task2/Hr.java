package task2;

import task1.BirthDate;
import task1.Name;

import java.util.List;


public class Hr {
    private static final int NUMBER_OF_SECRETARIES = 10;

    public Secretary getSecretary() {
        return new Secretary(new Name(), new BirthDate());
    }

    public boolean checkNumberOfSecretaries(List<Secretary> secretaries) {
        return secretaries.size() < NUMBER_OF_SECRETARIES;
    }
}
