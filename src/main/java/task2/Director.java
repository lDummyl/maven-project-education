package task2;

import java.util.List;
import java.util.Random;

public class Director {
    private Secretary secretary;

    public void makeDecision(List<WantAJob> candidates) {
        if (secretary == null) {
            Random random = new Random();
            //++ Debug
            int size = candidates.size() - 1;
            int index = random.nextInt(size);
            System.out.println(index + " " + size + " ");
            //--
            secretary = (Secretary) candidates.get(index);
        }
    }

    public Secretary getSecretary() {
        return secretary;
    }
}
