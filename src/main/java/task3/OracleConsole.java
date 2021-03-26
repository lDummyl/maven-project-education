package task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OracleConsole extends Oracle implements QuestionReader {
    public OracleConsole() throws IOException {
    }


    public String giveAnswer(String question) throws IOException {
        if (!question.equals("!")) {
            answer = super.giveAnswer(question);
        } else answer = null;
        return answer;
    }

    @Override
    public String readQuestion() throws IOException {
        return reader.readLine();
    }

    public List<Conversation> getConversationFromConsole() throws IOException {
        String question = readQuestion();
        String answer = giveAnswer(question);
        List<Conversation> conversation = new ArrayList<>();
        while (answer != null) {
            conversation.add(new Conversation(question, answer));
            answer = giveAnswer(question);
            question = readQuestion();
        }
        return conversation;
    }

    public List<Conversation> getConversations(List<String> list) throws IOException {
        List<Conversation> conversation = new ArrayList<>();
        for (String question : list) {
            String answer = giveAnswer(question);
            conversation.add(new Conversation(question, answer));
        }
        return conversation;
    }


}
