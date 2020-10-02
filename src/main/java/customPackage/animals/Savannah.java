package customPackage.animals;

public class Savannah {
    public static void main(String[] args) {
        Snake mamba = new Snake("Mamba", Gender.NEUTRAL, true);
        Parrot parrie = new Parrot("parrie", Gender.MALE, "green");
        Elephant biggie = new Elephant("Biggie", Gender.MALE);
        // snake bites and eats parrots
        mamba.bite(parrie);
        mamba.eats(parrie);
        // elephant steps on snake
        biggie.stepOn(mamba);
        System.out.println("Is snake alive after being squizzed by elephant? " + mamba.isAlive);
    }
}
