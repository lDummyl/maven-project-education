package simpleTasks.Cosmetics;

public class Lipstick extends Cosmetics{
    public String color;

    public Lipstick(String brand, double price, String color) {
        super(brand, price);
        this.color = color;
    }

    @Override
    public void apply() {

    }
}
