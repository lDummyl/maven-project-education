package simpleTasks.Cosmetics;

public abstract class Cream extends Cosmetics {
    private String skinType;

    public Cream(String brand, double price, String skinType) {
        super(brand, price);
        this.skinType = skinType;
    }

}
