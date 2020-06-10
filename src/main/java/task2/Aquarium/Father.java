package task2.Aquarium;

import java.util.ArrayList;
import java.util.List;

public class Father {

    List <Fish> healthFish = new ArrayList<>();

    public void giveSomePills (Fish fish){
        fish.isHealty = true;
        healthFish.add(fish);
    }
}
