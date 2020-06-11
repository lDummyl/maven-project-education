package task2.Aquarium;

import java.util.ArrayList;
import java.util.List;

public class WaterTank {

    Water water;

    public WaterTank() {
        this.water = new Water();
    }

    List<Fish> fishes = new ArrayList<>();

    public void put(List<Fish> list) throws WeNeedWaterException {
        if (water == null) {
            throw new WeNeedWaterException("There isn't water!!");
        } else
            fishes.addAll(list);
    }
}
