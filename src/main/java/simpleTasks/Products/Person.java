package simpleTasks.Products;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Person implements Eater {
    String name;
    int age;
    Set<String> preferFood = new HashSet<>();


    public void takePlate(Plate plate) {
    }

    public void eat() {
    }

    @Override
    public void eat(Food food) {
        String simpleName = food.getClass().getSimpleName();

        if(preferFood.contains(simpleName)){
            System.out.println("I'm satisfied with " + simpleName);
        }
        else{
            System.out.println("Fu " + simpleName);
        }
    }

}
