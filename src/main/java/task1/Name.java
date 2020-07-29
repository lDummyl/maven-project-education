package task1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Name {

    String firstName;
    String lastName;


    private static final ArrayList<String> firstNames = new ArrayList<>();
    private static final ArrayList<String> lastNames = new ArrayList<>();
    private static Random randomNumber;


    static {
        firstNames.add("Ivan");
        firstNames.add("Andrey");
        firstNames.add("Petr");
        firstNames.add("Evgeny");

        lastNames.add("Ivanov");
        lastNames.add("Petrov");
        lastNames.add("Andreev");
        lastNames.add("Sidorov");

        randomNumber = new Random();

    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name() {
        getRandomName();
    }

    private Name getRandomName() {
        this.firstName = firstNames.get(randomNumber.nextInt(firstNames.size()));
        this.lastName = lastNames.get(randomNumber.nextInt(lastNames.size()));
        return this;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName + ' ';
    }
}
