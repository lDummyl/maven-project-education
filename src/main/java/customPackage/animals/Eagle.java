package customPackage.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static customPackage.animals.Gender.FEMALE;
import static customPackage.animals.Gender.MALE;

public class Eagle extends Animal {
    public Eagle(String name, Gender gender) {
        super(name, gender);
    }

    public static void main(String[] args) {
        Eagle edgar = new Eagle("Edgar", Gender.MALE);
        System.out.println(edgar);
    }

    @Override
    public String scream() {
        return "Cle-e!";
    }

    public void eats(Animal animal) {
        if (animal instanceof Rookie || animal instanceof Rookie) {
            System.out.println("Eagle ate " + animal.name + "!");
        }
    }

    public Egg createEgg(Eagle other_parent) {
        Egg egg = null;
        if (other_parent.gender == this.gender) {
            System.out.println("No egg is created!");
        } else {
            egg = new Egg(name, Gender.MALE);
        }
        return egg;
    }

    private Gender newGender() {
        List<Gender> valid_genders = new ArrayList<Gender>();
        valid_genders.add(MALE);
        valid_genders.add(FEMALE);
        int pick = new Random().nextInt(valid_genders.size());
        return valid_genders.get(pick);
    }

    public BabyEagle mateUp(Animal animal) {
        if (animal instanceof Eagle == false) {
            return null;
        } else {
            Gender new_gender = newGender();
            BabyEagle newborn = new BabyEagle("baby eagle", new_gender);
            return newborn;
        }
    }

    public void nesting() {
        System.out.println("The eagle " + name + " is nesting!");
    }
}
