package task2.Aquarium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food {
    String name;


    public Food(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }
}
