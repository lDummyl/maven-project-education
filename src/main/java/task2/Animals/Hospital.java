package task2.Animals;

import java.util.ArrayList;
import java.util.List;

public class Hospital {


    List<Animal> vacinatedAnimals = new ArrayList<>();
//    public List<Animal> invite(List<Animal> list) {
//
//        for (Animal animal : list) {
//            animal.isVaccinated = true;
//        }
//        return list;
//    }

    public void invite(Animal animal) {
        animal.isVaccinated = true;
        vacinatedAnimals.add(animal);
    }
}
