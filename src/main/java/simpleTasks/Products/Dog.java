package simpleTasks.Products;

public class Dog implements Eater {
    boolean isFull;

    @Override
    public void eat(Food food) {
        System.out.println("Gaff " + food.getClass().getSimpleName());
        isFull = true;
    }

    public void bark() {
        int times = 2;
        if (isFull) {
            times = 10;
        }
        for (int i = 0; i < times; i++) {
            System.out.println("Woff");
        }
    }
}
