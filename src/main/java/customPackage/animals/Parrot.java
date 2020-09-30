package customPackage.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parrot extends Animal {
    private final String color;
    List<String> magicWords = new ArrayList<>();

    public Parrot(String name, boolean isAlive, String gender, String color) {
        super(name, isAlive, gender);
        this.color = color;
    }

    public static void main(String[] args) {
        Parrot kesha = new Parrot("Kesha", true, "male", "green");
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
}
