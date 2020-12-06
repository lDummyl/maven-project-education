package task4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Oracle;
import task3.Resolution;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// TODO: 05.12.2020 возможно сделал слишком много классов
public class OracleQuestionProvider {
    Oracle oracle = new Oracle();
    QuestionsGenerator questionsGenerator = new QuestionsGenerator();
    SerializerForAny serializer = new SerializerForAny();

    public void askOracleAndSerialize(int numberOfQuestions, String fileName) {
        List<Resolution> resolutions = askOracle(numberOfQuestions);
        serializer.serializeCollectionToJSON(resolutions, fileName);
    }

    public List<Resolution> askOracle(int numberOfQuestions) {

        List<Resolution> resolutions = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions; i++) {
            resolutions.add(oracle.ask(questionsGenerator.getQuestion()));
        }
        return resolutions;
    }

    // TODO: 06.12.2020 Получилось десериализовать, но не получилось сделать универсальным
    public Collection<Resolution> deserializeResolution(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        String type = ".json";
        String jsonArrayString = null;
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName + type), StandardCharsets.UTF_8);
            jsonArrayString = lines.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            Collection<Resolution> list = objectMapper.readValue(jsonArrayString, new TypeReference<List<Resolution>>() {
            });
            System.out.println(list);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
