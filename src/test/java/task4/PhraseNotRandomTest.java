package task4;

import org.junit.Test;
import task3.Question;

import java.util.List;

import static org.junit.Assert.*;

public class PhraseNotRandomTest {

    PhraseNotRandom phraseNotRandom = new PhraseNotRandom();

    @Test
    public void test(){
        int qty = 10;
        List<String> phrases = phraseNotRandom.generateQuestions(qty, Question.WHY);
        assertEquals(qty, phrases.size());
    }
}