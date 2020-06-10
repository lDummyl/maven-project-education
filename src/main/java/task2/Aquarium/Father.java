package task2.Aquarium;

public class Father {

    public void giveSomePills (WaterTank waterTank){
//        fish.isHealty = true;
//        healthFish.add(fish);
        for (Fish fish : waterTank.fishes) {
            fish.isHealthy = true;
        }
    }
}
