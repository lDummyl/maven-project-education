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




}