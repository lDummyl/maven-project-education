package customPackage.animals;

public class Test {

    public static void toPrint(Animal creature) {
        System.out.printf(creature.scream());
    }

    public static void main(String[] args) {
        Dog doggie = new Dog();
        Bird birdie = new Bird();
        toPrint(doggie);
        toPrint(birdie);
    }
}
