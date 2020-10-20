package customPackage.people;

import customPackage.plants.Blackberry;
import customPackage.plants.Fruit;
import customPackage.plants.Plant;

public class Gardener extends Person {
    public Gardener(String name, int age) {
        super(name, age);
    }

    public Blackberry getBlackerries() {
        Blackberry fruit_basket = new Blackberry("kiowa", 9, 300);
        return fruit_basket;
    }
}