package customPackage.animals;

public class Whale extends Animal {
    private final boolean hungry = true;

    public Whale(String name, boolean isAlive, Gender gender) {
        super(name, isAlive, gender);
    }

    public static void main(String[] args) {
        Whale toomie = new Whale("toomie", true, Gender.MALE);
        System.out.println(toomie);
        toomie.expelWater();
    }

    @Override
    public String scream() {
        return "O-omph!";
    }

    @Override
    public String toString() {
        return "Whale{" +
                "hungry=" + hungry +
                ", name='" + name + '\'' +
                '}';
    }

    public void expelWater() {
        System.out.println("Fountain!");
    }

    public void eatsKrill(Krill krill) {
        if (hungry) {
            System.out.println("Whale is no longer hungry!");
            krill.die();
        } else {
            System.out.println("Whale is already not hungry!");
        }
    }
}
