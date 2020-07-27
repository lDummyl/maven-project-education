package task2;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Director {

    Random randomNumber;

    public int chooseSecretary(int numberOfSecretaries) {
        try {
            randomNumber = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return randomNumber.nextInt(numberOfSecretaries);
    }

}
