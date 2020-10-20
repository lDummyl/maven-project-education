package customPackage.people;

import customPackage.plants.Fruit;

public abstract class Plantator extends Person {
    public Plantator(String name, int age){
        super(name, age);
    }
    public abstract Fruit rootPlant();
}
