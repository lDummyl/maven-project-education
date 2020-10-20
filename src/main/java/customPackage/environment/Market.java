package customPackage.environment;

import customPackage.people.Confectioner;
import customPackage.people.Gardener;
import customPackage.plants.Blackberry;
import customPackage.plants.Fruit;
import customPackage.plants.Jelly;

public class Market {
    public static void main(String[] args) {
        Confectioner confectioner = new Confectioner("Johnson", 35);
        Gardener gardener = new Gardener("Smith", 50);
        Blackberry fruit_basket = gardener.getBlackerries();
        boolean ready = confectioner.takeBerries(fruit_basket);
        if(ready){
            String jelly_jar = confectioner.produceJelly(fruit_basket);
            System.out.println("Confectioner produced Jelly jars: " + jelly_jar);
        }
    }
}
