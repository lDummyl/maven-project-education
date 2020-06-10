package task2.Aquarium;

import java.util.ArrayList;
import java.util.List;

public class Children {

    List <Food> food = new ArrayList<>();

    public void giveSomeMeal (canEat canEat){
        for (Food food : food) {
            if(canEat instanceof Fish){
                ((Fish) canEat).countOfMeals++;
                canEat.likeToEat(food);
            }
        }
    }

    public void playWithSatisfiedFish (List <Fish> list){
        for (Fish fish : list) {
        if(fish.countOfMeals>0 && fish.isHealty) {
            System.out.println(fish + " is happy! Because isHealty = " + fish.isHealty +
                    " and countOfMeals = " + fish.countOfMeals);
            }else {
            System.out.println(fish + " is dyed! Because isHealty = " + fish.isHealty +
                    " and countOfMeals = " + fish.countOfMeals + ". Children didn't give us food!");
        }
        }

    }
}
