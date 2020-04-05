package simpleTasks.Cosmetics;

public class Parfum extends Cosmetics {
    public String aroma;

    public Parfum(String brand, double price, String aroma) {
        super(brand, price);
        this.aroma = aroma;
    }

    @Override
    public void apply() { // TODO: 4/6/20 зачем тогда эти методы?
    }
}

