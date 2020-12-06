package task4;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;


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

    public<T extends JsonReady> Collection<T> deserialize(String fileName, Class<T> clazz){
        try {
            System.out.println(objectMapper.readValue(fileName + type, clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
