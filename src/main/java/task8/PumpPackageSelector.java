package task8;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task7.Pump;
import task7.PumpCollector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class PumpPackageSelector {
    PumpCollector pumpCollector = new PumpCollector();
    ObjectMapper objectMapper = new ObjectMapper();
    File fileWithPumps;

    public PumpPackageSelector(File fileWithPumps) {
        this.fileWithPumps = fileWithPumps;
    }

    public void getPumpReport(File fileWithRequests, File fileToReport) {
        Collection<PumpRequest> pumpRequests = initializePumpRequestFile(fileWithRequests);
        List<Pump> pumpsList = initializePumpFile(fileWithPumps);
        PumpReport report = getReport(pumpRequests, pumpsList);
        try {
            objectMapper.writeValue(fileToReport, report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getPumpReport(Collection<PumpRequest> requests, File fileToReport) {
        List<Pump> pumpsList = initializePumpFile(fileWithPumps);
        PumpReport report = getReport(requests, pumpsList);
        try {
            objectMapper.writeValue(fileToReport, report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PumpReport getReport(Collection<PumpRequest> requests, List<Pump> pumpsList) {
        return new PumpReport(pumpsList, requests);
    }

    private Collection<PumpRequest> initializePumpRequestFile(File fileWithRequests) {
        ArrayList<PumpRequest> pumpRequests = new ArrayList<>();
        try {
            pumpRequests = objectMapper.readValue(fileWithRequests, new TypeReference<List<PumpRequest>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (pumpRequests.size() == 0) {
            throw new IllegalStateException("There is no Requests");
        } else {
            return pumpRequests;
        }
    }

    private List<Pump> initializePumpFile(File fileWithPumps) {
        pumpCollector.setJsonFile(fileWithPumps);
        return pumpCollector.deserializeJson();
    }
}
