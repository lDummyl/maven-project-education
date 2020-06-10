package task2.Aquarium;

import java.util.ArrayList;
import java.util.List;

public class WaterTank {

    Water water;

    public WaterTank() {
        water = new Water();
    }

    List <Fish> weAreInTheWaterTank = new ArrayList<>();

    public void put(List <Fish> list){
        weAreInTheWaterTank.addAll(list);
    }
}
