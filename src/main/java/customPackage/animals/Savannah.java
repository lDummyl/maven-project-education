package customPackage.animals;

public class Savannah {
    public static void main(String[] args) {
        Snake mamba = new Snake("Mamba", true, "neutral", true);
        Parrot parrie = new Parrot("parrie", true, "male", "green");
        Elephant biggie = new Elephant("Biggie", true, "male");
        Monkey chimpie = new Monkey("Chimpie", true, "female");
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
