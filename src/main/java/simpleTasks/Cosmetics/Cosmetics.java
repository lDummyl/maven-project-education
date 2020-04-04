package simpleTasks.Cosmetics;

public abstract class Cosmetics {
    String brand;
    double price;

    public Cosmetics(String brand) {
        this.brand = brand;
    }

    public abstract CosmeticsApplying apply();
}
