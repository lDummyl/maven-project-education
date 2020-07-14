package task3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

    ObjectMapper mapper = new ObjectMapper();

    Map<String, String> statisticsFromQuestionAndAnswer = new HashMap<>();

    public void endSession() throws IOException {
        mapper.writeValue(new FileOutputStream("result.json"), statisticsFromQuestionAndAnswer);

    }

    public void saveStatistic(String question, String answer){
        statisticsFromQuestionAndAnswer.put(question, answer);
    }

}
