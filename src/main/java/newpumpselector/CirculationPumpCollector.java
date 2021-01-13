package newpumpselector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import task7.Pump;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class CirculationPumpCollector {
    private final File fileWithPumps;
    private final ObjectMapper mapper;

    public CirculationPumpCollector() {
        this.fileWithPumps = new File("src/main/resources/PumpFile.json");
        this.mapper = new ObjectMapper();
    }

    public List<Pump> getPumpList() {
        Collection<Pump> pumpsFromFile = getPumpsFromFile();
        return new ArrayList<>(pumpsFromFile);
    }

    @SneakyThrows
    public void addPumpToFile(Pump pump){
        HashSet<Pump> pumps = new HashSet<>(getPumpsFromFile());
        pumps.add(pump);
        try {
            mapper.writeValue(fileWithPumps, pumps);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            Files.copy(fileWithPumps.toPath(), Paths.get("PumpsBackup.json"), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    @SneakyThrows
    public Collection<Pump> getPumpsFromFile() {
        Collection<Pump> pumps;
        try {
            pumps = mapper.readValue(fileWithPumps, new TypeReference<Collection<Pump>>() {
            });
        } catch (IOException e) {
            System.err.println(e.getMessage());
            Files.copy(fileWithPumps.toPath(), Paths.get("PumpsBackup.json"), StandardCopyOption.REPLACE_EXISTING);
            pumps = new HashSet<>();
        }
        return pumps;
    }
}
