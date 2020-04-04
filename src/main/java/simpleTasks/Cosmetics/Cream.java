package simpleTasks.Cosmetics;

public class Cream extends Cosmetics {
    private String skinType;

    public Cream(String brand, String skinType) {
        super(brand);
        this.skinType = skinType;
    }

    @Override
    public CosmeticsApplying apply() {
        return null;
    }
}
