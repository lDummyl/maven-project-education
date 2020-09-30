package customPackage.animals;

public class PolarCircle {
    public static void main(String[] args) {
        Bear teddy = new Bear("Teddy", true, Gender.MALE);
        Salmon nameless = new Salmon("Nameless", true, Gender.NEUTRAL);
        teddy.catchFish(nameless);
        teddy.eatAvailableFish();
        Bear booxie = new Bear("Booxie", true, Gender.FEMALE);
        booxie.catchFish(nameless);
        booxie.eatAvailableFish();
        System.out.println(teddy);
        System.out.println(booxie);
    }
}
