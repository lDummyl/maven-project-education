package task2.AnimalsRepeat;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    List <Animal> vaccinatedAnimals = new ArrayList<>();

    public void invite (Animal animal){
        animal.isVaccinated = true;
        vaccinatedAnimals.add(animal);
    }

}
