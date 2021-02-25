package task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OracleConsole extends Oracle implements QuestionReader {
    public OracleConsole() throws IOException {
    }


    public String giveAnswer() throws IOException {
        while (true) {
            String question = readQuestion();
            if (question.equals("exit")) {
                answer = null;
                break;
            }
            answer = super.giveAnswer(question);
        }
        return answer;
    }

    @Override
    public String readQuestion() throws IOException {
        return reader.readLine();
    }

    List<Conversation> getConversationList() throws IOException {
        List<Conversation> conversation = new ArrayList<>();
        String answer = giveAnswer();
        while (answer != null) {
            answer = giveAnswer();
            conversation.add(new Conversation(readQuestion(), answer));
        }
        return conversation;
    }


}
