package customPackage.animals;

public class PolarCircle {
    public static void main(String[] args) {
        Bear teddy = new Bear("Teddy", true);
        Salmon nameless = new Salmon("Nameless", true);
        teddy.catchFish(nameless);
        teddy.eatAvailableFish();
        Bear booxie = new Bear("Booxie", true);
        booxie.catchFish(nameless);
        booxie.eatAvailableFish();
        System.out.println(teddy);
        System.out.println(booxie);
    }
}
