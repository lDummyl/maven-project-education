package task3;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConversationTest {

    Logger log = Logger.getLogger(Conversation.class.getName());
    Random random = new Random();
    String[] questions = {"what", "where", "when", "how", "why", "who", "not question", "just words"};
    String[] answers = {"anywhere", "sometimes", "whatever", "because", "not answer"};

    @Test
    @SneakyThrows
    public void testConversation() {
        Conversation conversation = new Conversation();
        Map<String, String> test = new HashMap<>();

        int questionsLength = questions.length;
        int answersLength = answers.length;
        int iterations = random.nextInt(6) + 5;
        for (int i = 0; i < iterations; i++) {
            test.put(questions[random.nextInt(questionsLength)], answers[random.nextInt(answersLength)]);
            log.info(test.toString());
        }

//        List<Conversation> list = Arrays.asList(new Conversation(), new Conversation());
//        Collections.sort(list, Comparator.comparing(Conversation::getStringJSON, ));
        for (Map.Entry<String, String> entry : test.entrySet()) {
            Thread.sleep(1000);
            conversation.addConversation(entry.getKey(), entry.getValue(), "");
        }

        String report = conversation.getStringJSON();
        log.info(report);
        assertFalse(report.equals(""));

        for (Map.Entry<String, String> entry : test.entrySet()) {
            assertTrue(report.contains(entry.getKey()));
            assertTrue(report.contains(entry.getValue()));
        }
    }

}