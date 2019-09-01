package task4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PhraseGenerator {

    public static final int MIN_COUNT_WORDS = 1;
    public static final int MAX_COUNT_WORDS = 4;
    private int countWords;
    private List<String> firstWords;
    private List<String> secondWords;
    private List<String> thirdWords;
    private List<String> fourthWords;
    private int firstWordsSize = 0;
    private int secondWordsSize = 0;
    private int thirdWordsSize = 0;
    private int fourthWordsSize = 0;
    private Random random = new Random();

    public PhraseGenerator() {
        this.countWords = 1;
        writeListWords();
    }

    public PhraseGenerator(int countWords) {
       setCountWords(countWords);
       writeListWords();
    }

    private void writeListWords() {
        firstWords = Arrays.asList("what", "where", "when", "how", "why", "who", "not", "just");
        secondWords = Arrays.asList("are you", "you felling", "I don't understand", "question", "words");
        thirdWords = Collections.singletonList("normal");
        fourthWords = Collections.singletonList("");

        firstWordsSize = firstWords.size();
        secondWordsSize = secondWords.size();
        thirdWordsSize = thirdWords.size();
        fourthWordsSize = fourthWords.size();
    }

    public String generatePhrase() {
        String phrase;

        phrase = getRandomElement(firstWords, firstWordsSize);
        if (countWords >= 2) {
            phrase += " " + getRandomElement(secondWords, secondWordsSize);
        }
        if (countWords >= 3) {
            phrase += " " + getRandomElement(thirdWords, thirdWordsSize);
        }
        if (countWords >= 4) {
            phrase += " " + getRandomElement(fourthWords, fourthWordsSize);
        }

        return phrase;
    }

    private String getRandomElement(List<String> list, int listSize) {
        return list.get(random.nextInt(listSize));
    }

    public void setCountWords(int countWords) {
        if (countWords >= MIN_COUNT_WORDS && countWords <= MAX_COUNT_WORDS) {
            this.countWords = countWords;
        }
    }
}
