package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class OracleTest {

    @Test
    public void answer() throws IOException {
        Oracle oracle = new Oracle();
        String answer = oracle.giveAnswer("Как дела?");
        assertEquals("ok", answer);
    }

    @Test
    public void negativeAnswer() throws IOException {
        Oracle oracle = new Oracle();
        String answer = oracle.giveAnswer("Как дела?");
        assertEquals("norm", answer);
    }

    @Parameterized.Parameters
    public static List<String> inputStrings() {
        return Arrays.asList(
                "как дела?", "какая на улице погода?", "почему жирафы не летают?", "кто, что, как, почему", "некто оказался в затруднительном положении", "как перестать лениться и начать работать");

    }

    @Test
    public void oracleAnswer() throws IOException {
        Oracle oracle = new Oracle();
        List list = inputStrings();
        for (Object o : list) {
            String question = o.toString();
            String answer = oracle.answer;
            String expectedAnswer = oracle.listOfAphorisms.get(oracle.listOfAphorisms.get(question));
            assertEquals(expectedAnswer, answer);
        }
    }

    @Test
    public void checkQuestion() throws IOException {
        Oracle oracle = new Oracle();
        List list = inputStrings();
        for (Object o : list) {
            String question = o.toString();
            String answer = String.valueOf(oracle.checkQuestion(question));
            String expectedAnswer = " ";
            int count = 0;
            if (question.length() < 10) {
                expectedAnswer = "Будь красноречивее";
                break;
            }
            if (question.length() > 30) {
                expectedAnswer = "Будь лаконичнее";
                break;
            }
            else if (oracle.isContainsQuestion(oracle.specialQuestions, question)) {
                count++;
                if (count > 1) {
                    expectedAnswer = "Ты задаешь слишком много вопросов";
                }
                else if (count == 1) {
                    expectedAnswer = oracle.answer(question);
                }
                else if (count == 0) {
                    expectedAnswer = "Не слышу вопроса в твоих речах";
                }
            }
            assertEquals(expectedAnswer, answer);

        }
    }


    @Test
    public void serialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Conversation conversation = new Conversation("a", "b");
        File file = new File("test.json");
        objectMapper.writeValue(file, conversation);
        Conversation resultConversation = objectMapper.readValue(file, Conversation.class);
        assertEquals(conversation, resultConversation);

    }


}