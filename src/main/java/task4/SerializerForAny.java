package task4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Resolution;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


// TODO: 05.12.2020 Можно было поместить в другое место, но я посчитал удобным сделать его отдельным классом
public class SerializerForAny {

    String type = ".json";
    ObjectMapper objectMapper = new ObjectMapper();

    public <T extends JsonReady> void serializeCollectionToJSON(Collection<T> listObjectsForSerialise, String fileName) {

        try {
            objectMapper.writeValue(new File(fileName + type), listObjectsForSerialise);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public <T extends JsonReady> Collection<T> deserialize(String fileName, Class<T> clazz) {
        String jsonArrayString = null;
        try {
          List<String> lines = Files.readAllLines(Paths.get(fileName+type), StandardCharsets.UTF_8);
          jsonArrayString = lines.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Resolution> list= objectMapper.readValue(jsonArrayString, new TypeReference<List<Resolution>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
