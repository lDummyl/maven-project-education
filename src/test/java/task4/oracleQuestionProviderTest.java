package task4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import task3.Resolution;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;


public class oracleQuestionProviderTest {
    ObjectMapper objectMapper = new ObjectMapper();
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
    // TODO: 06.12.2020 Получилось десериализовать, но не получилось сделать универсальным
    public Collection<Resolution> deserializeResolution(String fileName) {
        String type = ".json";
        String jsonArrayString = null;
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName+type), StandardCharsets.UTF_8);
            jsonArrayString = lines.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            Collection<Resolution> list= objectMapper.readValue(jsonArrayString, new TypeReference<List<Resolution>>() {});
            System.out.println(list);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}