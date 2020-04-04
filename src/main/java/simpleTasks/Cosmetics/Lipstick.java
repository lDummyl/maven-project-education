package simpleTasks.Cosmetics;

public class Lipstick extends Cosmetics{
    private String color;

    public Lipstick(String brand, String color) {
        super(brand);
        this.color = color;
    }

    @Override
    public CosmeticsApplying apply() {
        return null;
    }
}
