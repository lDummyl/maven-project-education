package newpumpbutchselector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import task8.PumpRequest;

import java.io.File;
import java.util.Collection;


public class CirculationBatchFileSelector {
    private final CirculationPumpBatchSelector selector;
    ObjectMapper mapper;

    public CirculationBatchFileSelector() {
        this.selector = new CirculationPumpBatchSelector();
        this.mapper = new ObjectMapper();
    }

    public void selectPumpsFromRequestFile(File fileWithRequests, File fileToWrite) {
        Collection<PumpRequest> requests = getRequests(fileWithRequests);
        writeToFile(requests, fileToWrite);
    }

    public CirculationPumpBatchReport getReportFromRequestFile(File fileWithRequests) {
        Collection<PumpRequest> requests = getRequests(fileWithRequests);
       return selector.selectPumpsWithReport(requests);
    }

    @SneakyThrows
    private void writeToFile(Collection<PumpRequest> requests, File fileToWrite) {
        mapper.writeValue(fileToWrite, requests);
    }

    @SneakyThrows
    private void writeToFile(CirculationPumpBatchReport report, File fileToWrite) {
        mapper.writeValue(fileToWrite, report);
    }

    @SneakyThrows
    private Collection<PumpRequest> getRequests(File fileWithRequests) {
        return mapper.readValue(fileWithRequests, new TypeReference<Collection<PumpRequest>>() {
        });
    }
}
