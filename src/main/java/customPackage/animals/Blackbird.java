package customPackage.animals;

public class Blackbird extends Animal {
    public Blackbird(String name, boolean isAlive, Gender gender) {
        super(name, true, gender);
    }

    public static void main(String[] args) {
        Blackbird bbird = new Blackbird("blackbird", true, Gender.MALE);
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
