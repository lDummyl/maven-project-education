package customPackage.animals;

public class Savannah {
    public static void main(String[] args) {
        Snake mamba = new Snake("Mamba", true, true);
        Parrot parrie = new Parrot("parrie", true, "green");
        Elephant biggie = new Elephant("Biggie", true);
        Monkey chimpie = new Monkey("Chimpie", true);
        // snake bites monkeys and eats parrots
        mamba.bite(chimpie);
        boolean squizzedbyElephant = biggie.stepOn(mamba);
        System.out.println("Is snake alive after being squizzed by elephant? " + mamba.isAlive);
        // elephant steps on snake
        // Change object state after their interaction - who eats whom; gender distinction and age
    }
}
