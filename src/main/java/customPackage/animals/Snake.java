package customPackage.animals;

public class Snake extends Animal {
    private final boolean poisonous;

    public Snake(String name, boolean isAlive, Gender gender, boolean poisonous) {
        super(name, isAlive, gender);
        this.poisonous = poisonous;
    }

    @Override
    public String scream() {
        return "Hiss!";
    }

    public void bite(Animal animal) {
        animal.health_status = false;
    }

    public void eats(Animal animal) {
        if (animal instanceof Parrot && animal.health_status == false) {
            System.out.println("Snake ate " + animal.name);
        }
    }
}
