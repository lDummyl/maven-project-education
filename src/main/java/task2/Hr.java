package task2;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Hr {
    Random randomNumber;

    public int getRandomSecretary(int numberOfSecretaries) {
        try {
            randomNumber = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return randomNumber.nextInt(numberOfSecretaries);
    }
}
