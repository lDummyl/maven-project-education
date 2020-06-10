package task2.Aquarium;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GoldFish goldFish = new GoldFish("Flaunder");
        BlueFish blueFish = new BlueFish("Pepe");
        GoldFish goldFish2 = new GoldFish("Mimi");
        BlueFish blueFish2 = new BlueFish("Zizi");
        GoldFish goldFish3 = new GoldFish("Zolla");
        BlueFish blueFish3 = new BlueFish("Ck");

        List<Fish> fishes = Arrays.asList(goldFish, goldFish2, goldFish3, blueFish, blueFish2, blueFish3);

        Food food = new Food("Royal Fish");
        Food food2 = new Food("Happy Fish");

        Children children = new Children();
        children.food.add(food);
        children.food.add(food2);

        Father father = new Father();

        for (Fish fish : fishes
        ) {
            father.giveSomePills(fish);
        }

        children.giveSomeMeal(goldFish);
        children.giveSomeMeal(blueFish2);
        children.giveSomeMeal(goldFish2);

        children.playWithSatisfiedFish(father.healthFish);


    }
}
