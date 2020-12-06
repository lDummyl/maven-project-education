package task4;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.FileReader;


public class oracleQuestionProviderTest {
    ObjectMapper mapper = new ObjectMapper();
    @Test
    public void askOracleAndSerialize() {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        String fileName = "task4";
        oracleQuestionProvider.askOracleAndSerialize(1000, fileName);

        String format = ".json";
        try {
            FileReader reader = new FileReader(fileName + format);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}