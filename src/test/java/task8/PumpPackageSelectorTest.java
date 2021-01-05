package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import task7.Pump;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PumpPackageSelectorTest {
    ObjectMapper objectMapper = new ObjectMapper();



    @Test
    public void fullSelectorTest() {
        String fileWithPumps = "PumpFile.json";
        String fileToReport = "PumpReport.json";

        File fileReport = new File(fileToReport);
        List<Pump> pumps = CollectionPump.addPumps();
        File filePumps = new File(fileWithPumps);
        try {
            objectMapper.writeValue(filePumps, pumps);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileWithRequests = "RequestFile.json";
        File fileRequest = new File(fileWithRequests);

        PumpPackageSelector pumpPackageSelector = new PumpPackageSelector(filePumps);
        RequestGenerator requestGenerator = new RequestGenerator();
        requestGenerator.generateRequestsToJson(fileRequest, 1_000);

        pumpPackageSelector.getPumpReport(fileRequest, fileReport);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.readValue(fileReport, new TypeReference<PumpReport>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}