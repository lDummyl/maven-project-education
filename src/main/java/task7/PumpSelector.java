package task7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class PumpSelector {
    private File jsonFile;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Collection<Pump> pumps = new ArrayList<>();

    public PumpSelector(File jsonSerialize) {
        if (jsonSerialize.exists()) {
            this.jsonFile = jsonSerialize;
        } else {
            this.jsonFile = new File(jsonSerialize.getPath());
        }
    }

    // TODO: 12/17/2020 Потенциальная проблема
    public PumpSelector() {
        if (!this.jsonFile.exists()) {
            this.jsonFile = new File("Pumps.json");
        }
    }

    public void addToJson(Pump pump) {
        try {
            Set<Pump> pumps = objectMapper.readValue(this.jsonFile, new TypeReference<Set<Pump>>() {
            });
            pumps.add(pump);
            objectMapper.writeValue(this.jsonFile, pumps);
        } catch (IOException e) {
            throw new IllegalArgumentException("Adding pump error");
        }
    }

    public void selectPump() {
        try {
            Set<Pump> pumps = objectMapper.readValue(this.jsonFile, new TypeReference<Set<Pump>>() {});

        } catch (IOException e) {

        }
    }
}
