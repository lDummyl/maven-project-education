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
    public void shortQuestion() throws IOException {
        Oracle oracle = new Oracle();
        String question = "как дела?";
        String expectedAnswer = "Будь красноречивее";
        assertEquals(oracle.giveAnswer(question), expectedAnswer);
    }

    @Test
    public void longQuestion() throws IOException {
        Oracle oracle = new Oracle();
        String question = "как перестать лениться и начать работать";
        String expectedAnswer = "Будь лаконичнее";
        assertEquals(oracle.giveAnswer(question), expectedAnswer);
    }

    @Test
    public void manyQuestions() throws IOException {
        Oracle oracle = new Oracle();
        String question = "кто, что, как, почему";
        String expectedAnswer = "Ты задаешь слишком много вопросов";
        assertEquals(oracle.giveAnswer(question), expectedAnswer);
    }

    @Test
    public void noQuestions() throws IOException {
        Oracle oracle = new Oracle();
        String question = "это слишком сложный вопрос";
        String expectedAnswer = "Не слышу вопроса в твоих речах";
        assertEquals(oracle.giveAnswer(question), expectedAnswer);
    }

    @Test
    public void getPositiveAnswer() throws IOException {
        Oracle oracle = new Oracle();
        String question = "какая на улице погода?";
        String expectedAnswer = "Прекрасная во всех отношениях";
        assertEquals(oracle.giveAnswer(question), expectedAnswer);
    }

    @Test
    public void getNegativeAnswer() throws IOException {
        Oracle oracle = new Oracle();
        String question = "какая на улице погода?";
        String expectedAnswer = "Возможно, что никогда";
        assertNotEquals(oracle.giveAnswer(question), expectedAnswer);
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
    public void invalidActions() throws IOException {
        Oracle oracle = new Oracle();
        Random random = new Random();
        String question = "какая на улице погода?";
        if (random.nextBoolean()) {
            System.out.println(oracle.invalidAnswers.get(Oracle.Action.HIT));
        }
    }


}