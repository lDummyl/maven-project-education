package customPackage.zoo.animals;

import customPackage.animals.Animal;

public class Cow extends Animal {
    private final int age;
    private final float weight;
    private final float length;

    public Cow(String name, int age, float weight, float length) {
        super(name);
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
