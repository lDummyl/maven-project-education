package customPackage.animals;

public class Snake extends Animal {
    private final String name;
    private final boolean poisonous;
    private final String extinct;
    private final float length;

    public Snake(String name, boolean poisonous, String extinct, float length) {
        this.name = name;
        this.poisonous = poisonous;
        this.extinct = extinct;
        this.length = length;
    }

    @Override
    public String scream() {
        return "Hiss!";
    }

    private String bite() {
        return "Venom!";
    }

}
