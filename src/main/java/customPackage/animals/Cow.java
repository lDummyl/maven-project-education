package customPackage.animals;

public class Cow extends Animal {
    private final int age;
    private final float weight;
    private final float length;

    public Cow(String name, boolean isAlive, int age, float weight, float length) {
        super(name, isAlive);
        this.age = age;
        this.weight = weight;
        this.length = length;
    }

    @Override
    public String scream() {
        return "Moo!";
    }

    private String getMilk() {
        return "Ready";
    }
}
