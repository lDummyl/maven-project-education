package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
//    @Parameterized.Parameters
//    public static List<String> inputStrings(){
//        return Arrays.asList(
//                "Как дела?", "какая на улице погода?" );
//    }

    @Test
    public void oracleAnswer() throws IOException {
        Oracle oracle = new Oracle();
        String firstQuestion = "Как дела?";
        String secondQuestion = "какая на улице погода?";
        String thirdQuestion = "почему жирафы не летают?";
            String answer = oracle.answer;
            String expectedAnswer = oracle.listOfAphorisms.get(oracle.listOfAphorisms.get(firstQuestion));
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