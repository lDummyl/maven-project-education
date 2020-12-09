package task4;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Resolution;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class ArraySerializerToJson {

    String type = ".json";
    ObjectMapper objectMapper = new ObjectMapper();

    public <T extends JsonReady> void serializeCollectionToJSON(Collection<T> listObjectsForSerialise, String fileName) {

        try {
            objectMapper.writeValue(new File(fileName + type), listObjectsForSerialise);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T extends JsonReady> Collection<T> deserializeJsonArray(String fileName, Class<T> clazz) {

        try {
            List<String> collect = Files.lines(Paths.get(fileName + type), StandardCharsets.UTF_8).collect(Collectors.toList());
            String objectArray = collect.get(0).replaceAll("[\\[\\]]", "");

          //  objectMapper.readValue(fileName + type, new TypeReference<List<T>>() {});

            String[] split = objectArray.split("},*");
            ArrayList<String> jsonStrings = new ArrayList<>();
            for (String s : split) {
                jsonStrings.add(s + "}");
            }
            Collection<T> deserialized = new ArrayList<>();
            for (String js : jsonStrings) {
                deserialized.add(objectMapper.readValue(js, clazz));
            }
            return deserialized;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
