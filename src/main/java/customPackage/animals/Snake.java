package customPackage.animals;

public class Snake extends Animal {
    private final boolean poisonous;
    private boolean alive = true;

    public Snake(String name, boolean poisonous) {
        super(name);
        this.poisonous = poisonous;
    }

    @Override
    public String scream() {
        return "Hiss!";
    }

    public void bite(Animal animal) {
        animal.health_status = false;
    }

    public boolean isAlive(boolean squizzed) {
        if (squizzed) {
            alive = false;
        }
        return alive;
    }

}
