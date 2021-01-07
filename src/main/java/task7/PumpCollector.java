package task7;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class PumpCollector {
    private File jsonPumpFile;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public PumpCollector(File jsonPumpFile) {
        if (this.jsonPumpFile.exists()) {
            this.jsonPumpFile = jsonPumpFile;
        } else {
            this.jsonPumpFile = new File(this.jsonPumpFile.getPath());
        }
    }


    public PumpCollector() {
        this.jsonPumpFile = new File("PumpFile.json");
    }

    public File getJsonPumpFile() {
        return jsonPumpFile;
    }

    public void setJsonPumpFile(File jsonPumpFile) {
        this.jsonPumpFile = jsonPumpFile;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    @SneakyThrows
    public void addToJson(Pump pump) {

        Set<Pump> pumps;
        pumps = deserializePumpJson();
        pumps.add(pump);
        objectMapper.writeValue(this.jsonPumpFile, pumps);
    }

    @SneakyThrows
    public void addToJson(Collection<Pump> pumpsColl) {
        Set<Pump> pumps = deserializePumpJson();
        pumps.addAll(pumpsColl);
        objectMapper.writeValue(this.jsonPumpFile, pumps);
    }

    @SneakyThrows
    public Set<Pump> deserializePumpJson() {
        Set<Pump> pumps;
        try {
            pumps = objectMapper.readValue(this.jsonPumpFile, new TypeReference<Set<Pump>>() {
            });
        } catch (IOException e) {
            System.err.println(e.getMessage());
            Files.copy(jsonPumpFile.toPath(), Paths.get("PumpsBackup.json"), StandardCopyOption.REPLACE_EXISTING);
            pumps = new HashSet<>();
        }
        return pumps;
    }
}
