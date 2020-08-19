package customPackage.animals;

public class Test {

    public static void toPrint(Animal creature) {
        System.out.printf(creature.scream());
    }

    public static void main(String[] args) {
        Dog doggie = new Dog("Beenie");
        Bird birdie = new Bird("Beekie");
        Donkey maxie = new Donkey("Max", 1, 100, "male");
        toPrint(doggie);
        toPrint(birdie);
    }
}
