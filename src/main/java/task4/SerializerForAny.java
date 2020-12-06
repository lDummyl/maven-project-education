package task4;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Resolution;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


// TODO: 05.12.2020 Можно было поместить в другое место, но я посчитал удобным сделать его отдельным классоме
// TODO: 06.12.2020 Сериализатор работает нормально
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
    public <T extends JsonReady> void serializeCollectionToCustomJSON(Collection<T> listObjectsForSerialise, String fileName) {

        try {

            File file = new File(fileName+type);
            file.delete();
            file.createNewFile();
            String s = objectMapper.writeValueAsString(listObjectsForSerialise);
            StandardOpenOption option = StandardOpenOption.APPEND;
            for (T o : listObjectsForSerialise) {
                String s1 = objectMapper.writeValueAsString(o);
                Files.write(Paths.get(fileName+type), (s1 + "#").getBytes(StandardCharsets.UTF_8), option);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: 06.12.2020 Работает в таком варианте, код гоязноват, как оказалось всё дело бвыло в сплитераторе в виде запятой, решилось через кастоснй json
    public <T extends JsonReady> Collection<T> deserializeCollectionFromFileCustom(String fileName, Class<T> clazz) {

        try {
            List<String> collect = Files.lines(Paths.get(fileName + type), StandardCharsets.UTF_8).collect(Collectors.toList());
            String objectArray = collect.get(0).replaceAll("[\\[\\]]", "");

            String[] split = objectArray.split("#");
            ArrayList<String> jsonStrings = new ArrayList<>();
            for (String s : split) {
                jsonStrings.add(s);
            }

            for (String js : jsonStrings) {
                System.out.println(js);
                T t = objectMapper.readValue(js, clazz);
                System.out.println(t);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
    // TODO: 07.12.2020 JsonMappingException
    /*public<T extends JsonReady> Collection<T> deserializeResolution(String fileName, Class<T> tClass) {
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

            TypeReference<List<T>> valueTypeRef = new TypeReference<List<T>>() {
            };
            Collection<Resolution> list = objectMapper.readValue(jsonArrayString, valueTypeRef);
            System.out.println(list);
            return (Collection<T>) list;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }*/
}
