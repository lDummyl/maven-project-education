package task3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class OracleMemory implements OracleHelper{

    private Map<String, String> statistic = new HashMap<>();


    public void saveStatistic(){
        ObjectMapper mapper = new ObjectMapper();
        File file = Paths.get("./result.json").toFile();
        try {
            mapper.writeValue(file, statistic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveMemory(String question, String answer){
        statistic.put(question, answer);
    }

    @Override
    public void assistOracle() {
        saveStatistic();
    }

    @Override
    public void assistOracle(String question, String answer){
        saveMemory(question, answer);
    }
}
