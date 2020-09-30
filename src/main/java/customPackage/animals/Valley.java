package customPackage.animals;

public class Valley {
    public static void main(String[] args) {
        Turkey goofie = new Turkey("Goofie", true, Gender.MALE);
        Sheep dollie = new Sheep("Dollie", true, Gender.FEMALE);
        Ram strongie = new Ram("Strongie", true, Gender.MALE, true);
        Donkey maxie = new Donkey("Maxie", true, Gender.MALE);
        Cow milkie = new Cow("Milkie", true, Gender.FEMALE, 5, 250, 2);
    }
}
