package customPackage.animals;

public class Valley {
    public static void main(String[] args) {
        Sheep dollie = new Sheep("Dollie", Gender.FEMALE);
        Ram strongie = new Ram("Strongie", Gender.MALE, true);
        Donkey maxie = new Donkey("Maxie", Gender.MALE);
        Cow milkie = new Cow("Milkie", Gender.FEMALE);
    }
}
