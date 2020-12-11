package task4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
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



        // TODO: 09.12.2020 Exception
       /*
        Function<Object, String> methodReference
        try {
            methodReference= objectMapper::writeValueAsString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        methodReference.apply(resolutions.get(0));*/
     /*   resolutionsDeserialized.stream().map(value -> {
            try {
                return objectMapper.writeValueAsString(value);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }).forEach(System.out::println);*/


    }
}
