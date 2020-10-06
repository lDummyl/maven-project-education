package customPackage.animals;

public class Valley {
    public static void main(String[] args) {
        Donkey maxie = new Donkey("Maxie", Gender.MALE);
        Cow milkie = new Cow("Milkie", Gender.FEMALE);

        lambGeneration();
    }

    private static void lambGeneration() {
        Sheep dollie = new Sheep("Dollie", Gender.FEMALE);
        Ram strongie = new Ram("Strongie", Gender.MALE, true);
        Lamb lamb = dollie.mateUp(strongie);
        Animal animal = lamb.growUp();
        System.out.println(animal.scream());
    }
}
