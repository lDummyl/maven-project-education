package task4;

import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Resolution;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class SerializeOneTest {

    // TODO: 06.12.2020 Не получается десериализовать объект
    @Test
    public void SomeTest() throws IOException {
        Resolution resolution = new Resolution("asdas", "sad ");
        ObjectMapper objectMapper = new ObjectMapper();
        String pathname = "OneObjext.json";
        objectMapper.writeValue(new File(pathname),resolution);
        String json = objectMapper.writeValueAsString(resolution);
        System.out.println(json);
        // TODO: 06.12.2020 Но получается из строки не из файла
        Resolution resolution1 = objectMapper.readValue(json, Resolution.class);
        System.out.println(resolution1);
    }
}
