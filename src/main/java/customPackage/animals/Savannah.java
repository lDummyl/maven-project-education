package customPackage.animals;

public class Savannah {
    public static void main(String[] args) {
        Snake mamba = new Snake("Mamba", true, Gender.NEUTRAL, true);
        Parrot parrie = new Parrot("parrie", true, Gender.MALE, "green");
        Elephant biggie = new Elephant("Biggie", true, Gender.MALE);
        Monkey chimpie = new Monkey("Chimpie", true, Gender.FEMALE);
        // snake bites and eats parrots
        mamba.bite(parrie);
        mamba.eats(parrie);

        // elephant steps on snake
        biggie.stepOn(mamba);
        biggie.stepOn(chimpie);
        System.out.println("Is snake alive after being squizzed by elephant? " + mamba.isAlive);
        System.out.println("Is chimp alive after being squizzed by elephant? " + chimpie.isAlive);
    }
}
