package customPackage.people;

import customPackage.plants.Blackberry;
import customPackage.plants.Fruit;
import customPackage.plants.Jelly;

public class Confectioner extends Person{
    public Confectioner(String name, int age){
        super(name, age);
    }

    public boolean takeBerries(Blackberry fruit_basket) {
        return true;
    }

    public String produceJelly(Blackberry fruit_basket) {
        return fruit_basket.getSimpleName();
    }

}
