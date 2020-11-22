package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionReader {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String question = reader.readLine();

    public QuestionReader() throws IOException {
    }
}
