package customPackage.animals;

public class Cow extends Animal {
    private String name;
    private int age;
    private float weight;
    private float length;

    public int Cow(String name, int age, float weight, float length) {
        int number = 0;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.length = length;
        return number;
    }

    @Override
    public String scream() {
        return "Moo!";
    }

    private String getMilk() {
        return "Ready";
    }
}
