package task2.Aquarium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    // TODO: 6/10/20 нормально, но рыбки без аквариума долго не протянут даже если их кормить.
    //  Против воды в нем они тоже не станут возражать, думаю.
    public static void main(String[] args) {
        WaterTank waterTank = new WaterTank();
        List<Fish> list = new ArrayList(Arrays.asList(new GoldFish("Flaunder"), new GoldFish("Mimi"),
                new BlueFish("Zizi"), new GoldFish("Zolla"), new BlueFish("Ck"), new BlueFish("Pepe")));
        waterTank.put(list);
        new Father().giveSomePills(waterTank);

        // TODO: 6/10/20 в мейне всегда логика для бога, лучше его не перегружать работой,
        //  циклами там разными и  ифами, и вообще сделай main в 10 строк
        Children children = new Children();
        children.food = new ArrayList(Arrays.asList(new Food("Royal Fish"), new Food("King Fish")));
        for (Fish f : waterTank.fishes) {
            children.giveSomeMeal(f);
        }
        children.playWithSatisfiedFish(waterTank.fishes);
    }
}

