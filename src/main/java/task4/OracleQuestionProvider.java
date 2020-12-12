package task4;

import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Oracle;
import task3.Resolution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OracleQuestionProvider {
    Oracle oracle;
    QuestionsGenerator questionsGenerator = new QuestionsGenerator();
    ObjectMapper objectMapper = new ObjectMapper();
    File file;

    public OracleQuestionProvider() {
    }

    public OracleQuestionProvider(Oracle oracle, String filePath) {
        this.oracle = oracle;
        this.file = new File(filePath);
    }

    public OracleQuestionProvider(String filePath) {
        this.file = new File(filePath);
    }

    public void askOracleAndSerialize(int numberOfQuestions, int timeToWait, File file) throws InterruptedException {
        List<Resolution> resolutions = askOracle(numberOfQuestions, timeToWait);
        try {
            objectMapper.writeValue(file, resolutions);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Resolution> askOracle(int numberOfQuestions, int timeToWait) throws InterruptedException {

        List<Resolution> resolutions = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions; i++) {
            Thread.sleep(timeToWait);
            resolutions.add(oracle.ask(questionsGenerator.getQuestion()));
        }
        return resolutions;
    }
}
