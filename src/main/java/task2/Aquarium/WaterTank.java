package task2.Aquarium;

import java.util.ArrayList;
import java.util.List;

public class WaterTank {

    Water water;

    public WaterTank() {
        water = new Water();
    }

    List <Fish> fishes = new ArrayList<>();

    public void put(List <Fish> list){
        if (water == null){
//            throw ...
        }
        fishes.addAll(list);
    }
}
