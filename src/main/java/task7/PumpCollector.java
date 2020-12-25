package task7;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class PumpCollector {
    private File jsonFile;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public PumpCollector(File jsonFile) {
        if (jsonFile.exists()) {
            this.jsonFile = jsonFile;
        } else {
            this.jsonFile = new File(jsonFile.getPath());
        }
    }

    public PumpCollector(String filePath) {
        this.jsonFile = new File(filePath);
    }

    public PumpCollector() {
    }

    public File getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(File jsonFile) {
        this.jsonFile = jsonFile;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void addToJson(Pump pump) {
        try {
            Set<Pump> pumps = null;
            try {
                pumps = objectMapper.readValue(this.jsonFile, new TypeReference<Set<Pump>>() {
                });
            } catch (IOException e) {
                System.err.println(e.getMessage());
                Files.copy(jsonFile.toPath(), Paths.get("PumpsBackup.json"), StandardCopyOption.REPLACE_EXISTING);
                pumps = new HashSet<>();
            }
            pumps.add(pump);
            objectMapper.writeValue(this.jsonFile, pumps);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Adding pump error");
        }
    }
    public List<Pump> deserializeJson(){
        try {
             List<Pump> pumps = objectMapper.readValue(this.jsonFile, new TypeReference<List<Pump>>() {
            });
             return pumps;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Pump>();
    }
}
