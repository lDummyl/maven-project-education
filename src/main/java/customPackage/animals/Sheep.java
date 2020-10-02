package customPackage.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static customPackage.animals.Gender.FEMALE;
import static customPackage.animals.Gender.MALE;

public class Sheep extends Animal {
    private final boolean ringBell;


    public Sheep(String name, Gender gender) {
        super(name, gender);
        this.ringBell = true;
    }

    @Override
    public String scream() {
        return "Baa!";
    }

    public boolean eatGrass() {
        return true;
    }

    private Gender newGender() {
        List<Gender> valid_genders = new ArrayList<Gender>();
        valid_genders.add(MALE);
        valid_genders.add(FEMALE);
        int pick = new Random().nextInt(valid_genders.size());
        return valid_genders.get(pick);
    }

    public Lamb mateUp(Animal animal) {
        if (animal instanceof Ram == false) {
            return null;
        } else {
            Gender new_gender = newGender();
            Lamb newborn = new Lamb("baby lamb", new_gender);
            return newborn;
        }
    }
}