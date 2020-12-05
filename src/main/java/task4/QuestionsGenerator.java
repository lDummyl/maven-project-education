package task4;

import task3.Oracle;
import task3.RegularAnswer;

import java.util.HashMap;
import java.util.Random;

public class QuestionsGenerator {
    public static final String[] secondWords = {"случится", "произойдёт", "поедет"};
    public static final String[] thirdWords = {"кот", "лампа", "пикабу", "запад"};
    String[] keyWords = Oracle.specialQuests;

    Random random = new Random();

    public QuestionsGenerator() {
        HashMap<String, String> answers = RegularAnswer.getAnswers();
    }

    public String getQuestion() {
        String firstWord = null;
        if (random.nextBoolean()) {
            firstWord = keyWords[(random.nextInt(keyWords.length))];
        } else if (random.nextBoolean()) {
            firstWord = "";
        } else {
            firstWord = keyWords[(random.nextInt(keyWords.length))] + keyWords[(random.nextInt(keyWords.length))];
        }

        String secondWord = secondWords[random.nextInt(secondWords.length)];
        String thirdWord;

        if (random.nextBoolean()) {
            thirdWord = thirdWords[random.nextInt(thirdWords.length)];
        } else {
            thirdWord = "";
        }
        int longChance = 100;
        int longChance2 = 90;
        String longWort = "";
        if (random.nextInt(longChance) > longChance2) {
            longWort = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        }
        return firstWord + secondWord + thirdWord + longWort;
    }
}
