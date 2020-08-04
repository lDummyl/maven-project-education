package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Hr {
    private static final int NUMBER_OF_SECRETARIES = 10;
    private static final int MIN_SKILLS = 5;
    private static final List<Secretary> secretaries = new ArrayList<>();

    public void checkSecretary(Object human) {
        // TODO: 7/29/20 не создает а отбирает, проводит интервью и складывает в папочку
        if (human instanceof Secretary) {
            passInterview((Secretary) human);
        }
    }

    public boolean checkNumberOfSecretaries() {
        return secretaries.size() < NUMBER_OF_SECRETARIES;
    }

    private void passInterview(Secretary secretary) {
        Random random = new Random();
        if (random.nextBoolean() && secretary.getSkills() > MIN_SKILLS) {
            secretaries.add(secretary);
        }
    }

    public Secretary transferControlTo(Director director) {
        if (!checkNumberOfSecretaries()) {
            return director.chooseSecretary(secretaries);
        } else {
            return null;
        }
    }
}
