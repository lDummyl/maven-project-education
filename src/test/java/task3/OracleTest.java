package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class OracleTest {

    @Test
    public void answer() throws IOException {
        Oracle oracle = new Oracle();
        String answer = oracle.giveAnswer("Как дела?");
        assertEquals("ok", answer );
    }
    @Test
    public void negativeAnswer() throws IOException {
        Oracle oracle = new Oracle();
        String answer = oracle.giveAnswer("Как дела?");
        assertEquals("norm", answer );
    }
    @Test
    public void oracleAnswer() throws IOException {
        QuestionReader reader = new QuestionReader();
        Oracle oracle = new Oracle();
        String question = reader.question;
        String answer = oracle.answer;
        String expectedAnswer = oracle.listOfAphorisms.get(oracle.listOfAphorisms.get(question));
        assertEquals(expectedAnswer, answer);
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