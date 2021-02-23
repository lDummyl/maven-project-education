package task3;

import java.io.IOException;
import java.util.List;

public class OracleConsole extends Oracle implements QuestionReader{
    public OracleConsole() throws IOException {
    }


    public String giveAnswer() throws IOException {
        while (true) {
            String question = readQuestion();
             answer = super.giveAnswer(question);
            if (question.equals("exit")) {
                answer = null;
                break;
            }
        }
        return answer;
    }

    @Override
    public String readQuestion() throws IOException {
         return reader.readLine();
    }


}
