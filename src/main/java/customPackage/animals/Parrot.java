package customPackage.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static customPackage.animals.Gender.FEMALE;
import static customPackage.animals.Gender.MALE;

public class Parrot extends Animal {
    private final String color;
    List<String> magicWords = new ArrayList<>();

    public Parrot(String name, Gender gender, String color) {
        super(name, gender);
        this.color = color;
    }

    public static void main(String[] args) {
        Parrot kesha = new Parrot("Kesha", Gender.MALE, "green");
        kesha.learnNewWord("Good luck!");
        kesha.learnNewWord("Good Fortune!");
        System.out.println(kesha.scream());
    }

    @Override
    public String scream() {
        return magicWords.get(new Random().nextInt(magicWords.size()));
    }

    public void learnNewWord(String word) {
        magicWords.add(word);
    }

    private Gender newGender() {
        List<Gender> valid_genders = new ArrayList<Gender>();
        valid_genders.add(MALE);
        valid_genders.add(FEMALE);
        int pick = new Random().nextInt(valid_genders.size());
        return valid_genders.get(pick);
    }

    public BabyParrot mateUp(Animal animal) {
        if (animal instanceof Parrot == false) {
            return null;
        } else {
            Gender new_gender = newGender();
            BabyParrot newborn = new BabyParrot("baby eagle", new_gender);
            return newborn;
        }
    }
}
