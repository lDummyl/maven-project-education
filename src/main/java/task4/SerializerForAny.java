package task4;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

// TODO: 05.12.2020 Можно было поместить в другое место, но я посчитал удобным сделать его отдельным классом
public class SerializerForAny {
    ObjectMapper objectMapper = new ObjectMapper();

    public<T extends JsonReady> void serializeListToJSON(Collection<T> listObjectsForSerialise, String fileName){
        try {
            objectMapper.writeValue(new File(fileName + ".json"), listObjectsForSerialise);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
