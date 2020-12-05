package task4;

import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Oracle;
import task3.Resolution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OracleAskGenerator {
    Oracle oracle = new Oracle();
    QuestionsGenerator questionsGenerator = new QuestionsGenerator();
    ObjectMapper objectMapper = new ObjectMapper();

    public void askAndSerialize(int numberOfQuestions){

        List<Resolution> resolutions = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions; i++) {
            resolutions.add(oracle.ask(questionsGenerator.getQuestion()));
        }

        try {
            objectMapper.writeValue(new File("ResolutionReport.json"), (resolutions));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new OracleAskGenerator().askAndSerialize(1000);
    }
}
