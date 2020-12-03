package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JacksonTesting {
    @Test
    public void writeToFile() throws IOException {
        Resolution sadasd = new Resolution("sadasd", "sdasdasd");
        ObjectMapper objectMapper = new ObjectMapper();
        String resolString = objectMapper.writeValueAsString(sadasd);
        StandardOpenOption option = StandardOpenOption.APPEND;
        Files.write(Paths.get("Testing.json"), (resolString + "\n").getBytes(StandardCharsets.UTF_8), option);

    }
}
