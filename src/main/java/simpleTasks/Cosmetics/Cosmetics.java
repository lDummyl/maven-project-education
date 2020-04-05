package simpleTasks.Cosmetics;

public abstract class Cosmetics {
    String brand;
    double price;
    private String makeUpSatisfaction;

    public Cosmetics(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }


    public abstract void apply();

 
}
