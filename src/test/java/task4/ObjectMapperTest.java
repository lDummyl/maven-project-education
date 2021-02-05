package task4;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import task3.Resolution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectMapperTest {
    @Test
    public void objectDesrialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Resolution> resolutions = new ArrayList<>();

        resolutions.add(new Resolution("question", "answer"));
        resolutions.add(new Resolution("question1", "answer2"));


        File file = new File("Testing.json");
        objectMapper.writeValue(file, resolutions);
        List<Resolution> resolutionsDeserialized = objectMapper.readValue(file, new TypeReference<List<Resolution>>() {
        });

        for (Resolution resol : resolutionsDeserialized) {
            String resolutionString = objectMapper.writeValueAsString(resol);
            System.out.println(resolutionString);
        }
    }
}
