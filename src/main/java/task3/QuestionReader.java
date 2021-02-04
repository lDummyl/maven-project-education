package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionReader {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<String> questionList = new ArrayList<>();

    public List<String> getQuestionList() throws IOException {
        while (true) {
            String question = reader.readLine();
            if (!question.equals("exit"))
            questionList.add(question);
            else
                break;
        }
        return questionList;
    }


    public QuestionReader() throws IOException {
    }
}
