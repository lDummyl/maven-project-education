package customPackage.animals;

public class Donkey extends Animal {
    private final String name;
    private final int age;
    private final float weight;
    private final String gender;

    public Donkey(String name, int age, float weight, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    @Override
    public String scream() {
        return "Bray!";
    }

    private String getLoad() {
        return "No-o";
    }
}