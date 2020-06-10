package task2.Aquarium;

import java.util.ArrayList;
import java.util.List;

public class WaterTank {

    Water water;

    public WaterTank() {
        Water water = new Water();
    }

    List<Fish> fishes = new ArrayList<>();

    public void put(List<Fish> list) {
        if (water == null) {
            list.clear();
            System.out.println("We must fill in our Water Tank!!!");
        } else
            fishes.addAll(list);
    }
}
