package customPackage.animals;

public class Blackbird extends Animal {
    public Blackbird(String name, boolean isAlive) {
        super(name, true);
    }

    public static void main(String[] args) {
        Blackbird bbird = new Blackbird("blackbird", true);
        bbird.keepFlying();
    }

    @Override
    public String scream() {
        return "Karr!";
    }

    public void keepFlying() {
        System.out.println("It's good!");
    }
}
