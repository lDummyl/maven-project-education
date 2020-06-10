package task2.Aquarium;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    // TODO: 6/10/20 нормально, но рыбки без аквариума долго не протянут даже если их кормить.
    //  Против воды в нем они тоже не станут возражать, думаю.
    public static void main(String[] args) {
        Random random = new Random();
        WaterTank waterTank = new WaterTank();

        GoldFish goldFish = new GoldFish("Flaunder");
        BlueFish blueFish = new BlueFish("Pepe");
        GoldFish goldFish2 = new GoldFish("Mimi");
        BlueFish blueFish2 = new BlueFish("Zizi");
        GoldFish goldFish3 = new GoldFish("Zolla");
        BlueFish blueFish3 = new BlueFish("Ck");
        List<Fish> fishes = Arrays.asList(goldFish, goldFish2, goldFish3, blueFish, blueFish2, blueFish3);
        waterTank.put(fishes);

        Food food = new Food("Royal Fish");
        Food food2 = new Food("Happy Fish");

        Children children = new Children();
        children.food.add(food);
        children.food.add(food2);

        Father father = new Father();

        father.giveSomePills(waterTank);

        for (Fish fish : waterTank.weAreInTheWaterTank) {
            if (random.nextBoolean()) {
                children.giveSomeMeal(fish);
            }
        }
            children.playWithSatisfiedFish(waterTank.weAreInTheWaterTank);

        }
    }

