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

    public void getPumpReport(File fileWithRequests) {
        Collection<PumpRequest> pumpRequests = initializePumpRequestFile(fileWithRequests);
        List<Pump> pumpsList = initializePumpFile(fileWithPumps);
        getReport(pumpRequests, pumpsList);
    }

    private void getReport(Collection<PumpRequest> requests, List<Pump> pumpsList) {

    }

    private Collection<PumpRequest> initializePumpRequestFile(File fileWithRequests) {
        ArrayList<PumpRequest> pumpRequests = new ArrayList<>();
        try {
           pumpRequests = objectMapper.readValue(fileWithRequests, new TypeReference<List<PumpRequest>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (pumpRequests.size() == 0){
            throw new IllegalStateException("There is no Requests");
        }
        else {
            return pumpRequests;
        }
    }

    private List<Pump> initializePumpFile(File fileWithPumps) {
        pumpCollector.setJsonFile(fileWithPumps);
        return pumpCollector.deserializeJson();
    }
}
