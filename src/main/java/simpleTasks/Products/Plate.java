package simpleTasks.Products;

public class Plate extends Dishes {
    Food foodOnPlate;

    public void putFoodOnPlate(Food food){
        if(foodOnPlate == null){
            foodOnPlate = food;
        }
        else{
            System.out.println("We've already had " + foodOnPlate.getClass().getSimpleName() + " on the plate");
        }
    }
}
