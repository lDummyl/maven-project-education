package task2;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Secretary {

    private static Random randomNumber = new Random();
    private static final ArrayList<String> firstNames = new ArrayList<>();
    private static final ArrayList<String> lastNames = new ArrayList<>();

    String firstName;
    String lastName;

    static {
        firstNames.add("Ivan");
        firstNames.add("Andrey");
        firstNames.add("Petr");
        firstNames.add("Evgeny");

        lastNames.add("Ivanov");
        lastNames.add("Petrov");
        lastNames.add("Andreev");
        lastNames.add("Sidorov");

        try {
            randomNumber = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Secretary() {
        this.firstName = getRandomFirstName();
        this.lastName = getRandomLastName();
    }

    private String getRandomFirstName() {
        return firstNames.get(randomNumber.nextInt(firstNames.size()));
    }

    private String getRandomLastName() {
        return lastNames.get(randomNumber.nextInt(lastNames.size()));
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
