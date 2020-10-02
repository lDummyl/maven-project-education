package customPackage.animals;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static customPackage.animals.Gender.FEMALE;
import static customPackage.animals.Gender.MALE;

public class Cow extends Animal {


    public Cow(String name, Gender gender) {
        super(name, gender);
        this.gender = FEMALE;
    }

    @Override
    public String scream() {
        return "Moo!";
    }

    private Gender newGender() {
        List<Gender> valid_genders = new ArrayList<Gender>();
        valid_genders.add(MALE);
        valid_genders.add(FEMALE);
        int pick = new Random().nextInt(valid_genders.size());
        return valid_genders.get(pick);
    }

    public Calf mateUp(Animal animal) {
        if (animal instanceof Bull == false) {
            return null;
        } else {
            Gender new_gender = newGender();
            Calf newborn = new Calf("baby calf", new_gender);
            return newborn;
        }
    }

//    public static void main(String[] args) {
//        Calf new_baby;
//        Calf one_more_baby;
//        Cow millie = new Cow("Millie", FEMALE);
//        Bull billie = new Bull("Billie", MALE);
//        new_baby = millie.mateUp(billie);
//        System.out.println(new_baby.name + " -- " + new_baby.gender);
//        Dog pirate = new Dog("Pirate", MALE);
//        one_more_baby = millie.mateUp(pirate);
//        if (one_more_baby != null){
//            System.out.println(one_more_baby.name + " -- " + one_more_baby.gender);
//        }
//        else {
//            System.out.println("Cows mate only with bulls!");
//        }
//
//    }
}
