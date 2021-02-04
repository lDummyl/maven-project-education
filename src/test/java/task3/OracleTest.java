package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class OracleTest {

    @Parameterized.Parameters
    public static List<String> inputStrings() {
        return Arrays.asList(
                "кто, что, как, почему", "как дела?", "какая на улице погода?", "почему жирафы не летают?", "некто оказался в затруднительном положении", "как перестать лениться и начать работать");

    }

    @Test
    public void validAnswer() throws IOException {
        Oracle oracle = new Oracle();
        String question = "почему жирафы не летают?";
        String answer = oracle.answer(question);
        assertFalse(answer.isEmpty());
    }

    @Test
    public void invalidAnswer() throws IOException {
        Oracle oracle = new Oracle();
        String invalidQuestion = "некто оказался в затруднительном положении";
        String answer = oracle.answer(invalidQuestion);
        Collection<String> validAnswers = oracle.mapOfQuestionsAndAnswers.values();
        boolean contains = validAnswers.contains(answer);
        assertTrue(contains);
    }
    @Test
    public void isContains() throws IOException {
        Oracle oracle = new Oracle();
        String shortQuestion = "как дела?";
        int qty = oracle.isContainsQuestion(oracle.mapOfQuestionsAndAnswers, shortQuestion);
        assertEquals(qty, 1);
    }

    @Test
    public void testShortQuestion() throws IOException {
        Oracle oracle = new Oracle();
        String shortQuestion = "как дела?";
        String answer = oracle.checkLengthAndQtySpecialQuestions(shortQuestion);
        assertEquals(oracle.invalidAnswers.get(Oracle.Action.MORE_ELOQUENCE), answer);
    }

    @Test
    public void testLongQuestion() throws IOException {
        Oracle oracle = new Oracle();
        String longQuestion = "сколько котов может поместиться в одной комнате";
        String answer = oracle.checkLengthAndQtySpecialQuestions(longQuestion);
        assertEquals(oracle.invalidAnswers.get(Oracle.Action.MORE_LACONIC), answer);
    }

    @Test
    public void testNoQuestions() throws IOException {
        Oracle oracle = new Oracle();
        String questionsWithoutSpecialQuestion = "некто оказался в затруднительном положении";
        String answer = oracle.checkLengthAndQtySpecialQuestions(questionsWithoutSpecialQuestion);
        assertEquals(oracle.invalidAnswers.get(Oracle.Action.NO_QUESTIONS), answer);
    }

    @Test
    public void testTooMuchQuestions() throws IOException {
        Oracle oracle = new Oracle();
        String questionsWithoutSpecialQuestion = "кто, что, как, почему";
        String answer = oracle.checkLengthAndQtySpecialQuestions(questionsWithoutSpecialQuestion);
        assertEquals(oracle.invalidAnswers.get(Oracle.Action.MANY_QUESTIONS), answer);
    }

    @Test
    public void serialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Conversation conversation = new Conversation("a", "b");
        File file = new File("conversation.json");
        objectMapper.writeValue(file, conversation);
        Conversation resultConversation = objectMapper.readValue(file, Conversation.class);
        assertEquals(conversation, resultConversation);
    }

    @Test
    public void wordSeparation() {
        String question = "какая   на улице погода?";
        String question2 = "какая, на улице погода?";
        String[] rawWords = question.split(" ");
        String[] rawWordsInQuestion2 = question2.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String rawWord : rawWordsInQuestion2) {
            String replace = rawWord.replaceAll(",", "");
            list.add(replace);
        }
        System.out.println(rawWords);
    }

    @Test
    public void giveAnswer() {

        HashMap<String, Collection<String>> questionAnswerMap = new HashMap<>();
        questionAnswerMap.put("какая", Arrays.asList("answer1", "answer2"));
        String question = "какая на улице погода?";
        Random random = new Random();
        String[] words = question.split(" ");
        for (String word : words) {
            Collection<String> possibleAnswers = questionAnswerMap.get(word);
            if (possibleAnswers != null) {
                ArrayList<String> list = new ArrayList<>(possibleAnswers);
                System.out.println(list.get(random.nextInt(list.size())));
            }
        }
    }

    @Test
    public void invalidActions() throws IOException {
        Oracle oracle = new Oracle();
        Random random = new Random();
        String question = "какая на улице погода?";
        if (random.nextBoolean()) {
            System.out.println(oracle.invalidAnswers.get(Oracle.Action.HIT));
        }
    }

    @Test
    public void testSleep() throws IOException {
        Oracle oracle = new Oracle();
        Random random = new Random();
        String question = "какая на улице погода?";
        if (random.nextBoolean()) {
            oracle.sleep();
        }
    }


}