package customPackage.animals;

public class Falcon extends Animal {
    private boolean seePrey;
    private boolean hungry = true;

    public Falcon(String name, boolean isAlive, Gender gender) {
        super(name, isAlive, gender);
    }

    public static void main(String[] args) {
        Falcon faddie = new Falcon("Faddie", true, Gender.FEMALE);
        Salmon nameless = new Salmon("nameless", true, Gender.NEUTRAL);
        System.out.println(faddie.scream());
        faddie.catchFish(nameless);
        System.out.println(faddie);
    }

    @Override
    public String scream() {
        return "Kla-a!";
    }

    @Override
    public String toString() {
        return "Falcon{" +
                "seePrey=" + seePrey +
                ", hungry=" + hungry +
                '}';
    }

    public boolean readyToHunt(boolean seePrey) {
        return true;
    }

    public void catchFish(Salmon fish) {
        if (fish.canBeEaten) {
            fish.canBeEaten = false;
            hungry = false;
        }
    }
}
