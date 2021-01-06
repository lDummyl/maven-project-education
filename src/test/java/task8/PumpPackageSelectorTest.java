package task8;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import task7.Pump;
import task7.PumpCollector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PumpPackageSelectorTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void createTestDataFile(){
        List<Pump> pumps = CollectionPump.addPumps();
        PumpCollector pumpCollector = new PumpCollector();
        pumpCollector.addToJson(pumps);
    }

    @Test
    public void testBatch(){
        List<PumpRequest> pumpRequestList = Arrays.asList(new PumpRequest(1.0, 60.0), new PumpRequest(100.0, 200.0));


        PumpPackageSelector selector = new PumpPackageSelector();
        List<PumpTechResponse> pumps = selector.selectPumps(pumpRequestList);


        assertEquals(pumpRequestList.size(), pumps.size());

    }
    @Test
    public void testFilesBatch(){
        File fileWithRequests = new File("RequestFile.json");
        PumpFilePackageSelector selector = new PumpFilePackageSelector();
        File fileWithSelectedPumps =  selector.selectPumpsToFile(fileWithRequests);


        /*assertEquals(5, selectedPupsList.size());*/
    }
}