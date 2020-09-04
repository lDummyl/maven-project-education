package task3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Memory {

    private Map<String, String> statistic = new HashMap<>();


    public void saveStatistic() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = Paths.get("./result.json").toFile();
            mapper.writeValue(file, statistic);
    }

    public void saveMemory(String question, String answer){
        statistic.put(question, answer);
        System.out.println(answer);
    }
}
