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
import java.util.Collection;
import java.util.HashSet;


public class CirculationPumpFileCollector implements CirculationPumpCollector {
    private final File fileWithPumps;
    private final ObjectMapper mapper;

    public CirculationPumpFileCollector() {
        this.fileWithPumps = new File("src/main/resources/PumpFile.json");
        this.mapper = new ObjectMapper();
    }

    @SneakyThrows
    public void addPump(Pump pump) {
        HashSet<Pump> pumps = new HashSet<>(getPumps());
        pumps.add(pump);
        try {
            mapper.writeValue(fileWithPumps, pumps);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            Files.copy(fileWithPumps.toPath(), Paths.get("PumpsBackup.json"), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    @SneakyThrows
    public Collection<Pump> getPumps() {
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
