package task8.selector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import task8.PumpRequest;
import task8.report.PumpBatchReport;
import task8.selector.PumpBatchSelector;

import java.io.File;
import java.util.Collection;


public class PumpFileSelector {
    private final PumpBatchSelector selector;
    ObjectMapper mapper;

    public PumpFileSelector() {
        this.selector = new PumpBatchSelector();
        this.mapper = new ObjectMapper();
    }

    public void selectPumpsFromRequestFile(File fileWithRequests, File fileToWrite) {
        Collection<PumpRequest> requests = getRequests(fileWithRequests);
        writeToFile(requests, fileToWrite);
    }

    public PumpBatchReport getReportFromRequestFile(File fileWithRequests) {
        Collection<PumpRequest> requests = getRequests(fileWithRequests);
        return selector.selectPumpsWithReport(requests);
    }

    @SneakyThrows
    private void writeToFile(Collection<PumpRequest> requests, File fileToWrite) {
        mapper.writeValue(fileToWrite, requests);
    }

    @SneakyThrows
    private void writeToFile(PumpBatchReport report, File fileToWrite) {
        mapper.writeValue(fileToWrite, report);
    }

    @SneakyThrows
    private Collection<PumpRequest> getRequests(File fileWithRequests) {
        return mapper.readValue(fileWithRequests, new TypeReference<Collection<PumpRequest>>() {
        });
    }
}
