package task4;

import task3.Oracle;


import java.util.*;

public class QuestionsGenerator {
    public static final String[] secondWords = {"случится", "произойдёт", "поедет"};
    public static final String[] thirdWords = {"кот", "лампа", "пикабу", "запад"};

    Random random = new Random();
    List<String> keyWords = new ArrayList<>(Oracle.answers.keySet());

    public QuestionsGenerator() {
    }

    public String getQuestion() {
        String firstWord = null;
        if (random.nextBoolean()) {
            firstWord = keyWords.get(random.nextInt(keyWords.size()));
        } else if (random.nextBoolean()) {
            firstWord = "";
        } else {
            firstWord = keyWords.get(random.nextInt(keyWords.size())) + keyWords.get(random.nextInt(keyWords.size()));
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
        return firstWord + " " + secondWord + " " + thirdWord + " " + longWort;
    }
}
