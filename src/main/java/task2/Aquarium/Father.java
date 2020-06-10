package task2.Aquarium;

import java.util.ArrayList;
import java.util.List;

public class Father {

//

    public void giveSomePills(WaterTank waterTank) {
//        fish.isHealty = true;
//        healthFish.add(fish);
        for (Fish fish : waterTank.fishes) {
            fish.isHealthy = true;
        }
    }
}
