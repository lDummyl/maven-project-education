package task2;


import java.util.ArrayList;
import java.util.List;

public class Hr {

    private static int numberOfSecretaries = 10;

    private Hr(){}

    public static List<Secretary> getSecretaries() {
        ArrayList<Secretary> secretaries = new ArrayList<>();
        for (int i = 0; i < numberOfSecretaries; i++) {
            secretaries.add(new Secretary());
        }
        return secretaries;
    }
}
