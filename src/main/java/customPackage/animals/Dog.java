package customPackage.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static customPackage.animals.Gender.FEMALE;
import static customPackage.animals.Gender.MALE;

public class Dog extends Animal {


    public Dog(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public String scream() {
        return "bark!";
    }

    public boolean bite(boolean threat) {
        boolean biten;
        biten = threat;
        return biten;
    }

    private Gender newGender() {
        List<Gender> valid_genders = new ArrayList<Gender>();
        valid_genders.add(MALE);
        valid_genders.add(FEMALE);
        int pick = new Random().nextInt(valid_genders.size());
        return valid_genders.get(pick);
    }

    public Puppy mateUp(Animal animal) {
        if (animal instanceof Dog == false) {
            return null;
        } else {
            Gender new_gender = newGender();
            Puppy newborn = new Puppy("baby puppy", new_gender);
            return newborn;
        }
    }
}
