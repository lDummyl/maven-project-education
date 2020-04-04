package simpleTasks.Cosmetics;

public class Parfum extends Cosmetics{
    private String aroma;

    public Parfum(String brand, String aroma) {
        super(brand);
        this.aroma = aroma;
    }

    @Override
    public CosmeticsApplying apply() {
        if (aroma.equals("Flowers")){
            return new CosmeticsApplying(this, "Nice choice");
        }
        else{
            return new CosmeticsApplying(this, "So-so");
        }
    }
}
