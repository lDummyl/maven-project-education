package task7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.Set;

public class PumpCollector {
    private File jsonFile;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public PumpCollector(File jsonSerialize) {
        if (jsonSerialize.exists()) {
            this.jsonFile = jsonSerialize;
        } else {
            this.jsonFile = new File(jsonSerialize.getPath());
        }
    }

    // TODO: 12/17/2020 Потенциальная проблема
    public PumpCollector() {
        if (!this.jsonFile.exists()) {
            this.jsonFile = new File("Pumps.json");
        }
    }

    public void addToJson(Pump pump) {
        try {
          /*  Set<Pump> pumps = objectMapper.readValue(this.jsonFile, new TypeReference<Set<Pump>>() {
            });
            pumps.add(pump);*/
            objectMapper.writeValue(this.jsonFile,pump);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Adding pump error");
        }
    }
}
