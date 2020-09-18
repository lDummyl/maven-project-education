package customPackage.animals;

public class Whale extends Animal {
    public Whale(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Whale toomie = new Whale("toomie");
        System.out.println(toomie);
        toomie.expelWater();
    }

    @Override
    public String scream() {
        return "O-omph!";
    }

    public void expelWater() {
        System.out.println("Fountain!");
    }
}
