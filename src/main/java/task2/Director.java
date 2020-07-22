package task2;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class Director {

    static Random randomNumber;

    public static Secretary getRandomSecretary(List<Secretary> secretaries) {
        try {
            randomNumber = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return secretaries.get(randomNumber.nextInt(9));
    }

}
