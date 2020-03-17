package task2;

import java.util.Random;

public class HR {
    Random random = new Random();

    double tellBossKPIOfEmployees() {
        return random.nextInt(20) * 1.0;
    }
}
