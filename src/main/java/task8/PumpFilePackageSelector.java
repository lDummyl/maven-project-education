package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;


import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public class PumpFilePackageSelector {
    private final PumpPackageSelector selector;
    ObjectMapper objectMapper = new ObjectMapper();
    public PumpFilePackageSelector() {
         this.selector = new PumpPackageSelector();
    }

    public File selectPumpsToFile(File fileWithRequests) {
        List<PumpRequest> requests = readFileWithRequests(fileWithRequests);
        List<PumpTechResponse> pumps = selector.selectPumps(requests);
        return writePumpsToFile(pumps);
    }
    @SneakyThrows
    private List<PumpRequest> readFileWithRequests(File fileWithRequests) {
        return objectMapper.readValue(fileWithRequests, new TypeReference<List<PumpRequest>>() {
        });
    }

    @SneakyThrows
    private File writePumpsToFile(List<PumpTechResponse> pumps) {
        LocalDateTime now = LocalDateTime.now();
        File resultFile = new File("PumpSelection" + now.toString().replaceAll(":", "-") + ".json");
        resultFile.createNewFile();
        objectMapper.writeValue(resultFile,pumps);
        return resultFile;
    }
}
