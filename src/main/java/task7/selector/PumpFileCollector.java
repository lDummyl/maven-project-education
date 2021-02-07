package task7.selector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import task7.pump.Pump;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class PumpFileCollector implements PumpCollector {
    private final File fileWithPumps;
    private final ObjectMapper mapper;

    public PumpFileCollector() {
        this.fileWithPumps = new File("src/main/resources/PumpFile.json");
        this.mapper = new ObjectMapper();
    }

    public PumpFileCollector(File fileWithPumps) {
        this.fileWithPumps = fileWithPumps;
        this.mapper = new ObjectMapper();
    }

    public void addPump(Pump pump) {
        HashSet<Pump> pumps = new HashSet<>(getPumps());
        pumps.add(pump);
        writePumps(pumps);
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

    @SneakyThrows
    private void writePumps(Set<Pump> pumps) {
        try {
            mapper.writeValue(fileWithPumps, pumps);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            Files.copy(fileWithPumps.toPath(), Paths.get("PumpsBackup.json"), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
