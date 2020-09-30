package customPackage.animals;

public class PolarCircle {
    public static void main(String[] args) {
        Bear teddy = new Bear("Teddy", true, "male");
        Salmon nameless = new Salmon("Nameless", true, "neutral");
        teddy.catchFish(nameless);
        teddy.eatAvailableFish();
        Bear booxie = new Bear("Booxie", true, "female");
        booxie.catchFish(nameless);
        booxie.eatAvailableFish();
        System.out.println(teddy);
        System.out.println(booxie);
    }
}
