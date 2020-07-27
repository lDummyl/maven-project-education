package task2;


import java.util.ArrayList;
import java.util.List;

public class Hr {

    //private static int numberOfSecretaries = 10;
    private static int countOfSecretaries = 0;
    private static List<Secretary> secretaries = new ArrayList<>();

    public Secretary getSecretaries(int i) {
        return secretaries.get(i);
    }

    public void setSecretaries(Secretary secretary) {
        secretaries.add(secretary);
        countOfSecretaries++;
    }

    public int getCountOfSecretaries() {
        return countOfSecretaries;
    }
}
