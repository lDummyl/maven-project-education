package customPackage.animals;

public class Bear extends Animal {
    private boolean hasFish;
    private boolean hungry = true;
    private Salmon fish;

    public Bear(String name, boolean isAlive, String gender) {
        super(name, isAlive, gender);
    }

    @Override
    public String toString() {
        return "Bear{" +
                "hasFish=" + hasFish +
                ", hungry=" + hungry +
                ", fish=" + fish +
                ", name='" + name + '\'' +
                ", health_status=" + health_status +
                '}';
    }

    @Override
    public String scream() {
        return "Roar";
    }

    public void catchFish(Salmon fish) {
        if (fish.canBeEaten) {
            hasFish = true;
            this.fish = fish;
        }

    }

    public void eatAvailableFish() {
        if (hungry && hasFish && fish.canBeEaten) {
            hungry = false;
            fish.canBeEaten = false;
        }
    }
}
