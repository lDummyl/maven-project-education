package task8;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import task7.Pump;

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
    public void fullSelectorTest() throws IOException {
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


        PumpReport pumpReport = objectMapper.readValue(fileReport, PumpReport.class);

        List<PumpTechResponse> pumpTechResponses = pumpReport.getPumpTechResponses();
        pumpTechResponses.forEach(Assert::assertNotNull);


        PumpCommercialBlock commercialBlock = pumpReport.getCommercialBlock();
        assertNotNull(commercialBlock.getPriceInTotal());
        assertTrue(commercialBlock.getPriceInTotal() > 10_000);


        assertTrue(commercialBlock.getPriceWithDelivery() > 10_000);
        assertTrue(commercialBlock.getNumberOFUniqModels() > 0);
    }
    @Test
    public void anotherDeliveryCoastTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String fileWithPumps = "PumpFile.json";
        String fileToReport = "PumpReport.json";

        File fileReport = new File(fileToReport);
        List<Pump> pumps = CollectionPump.addPumps();
        Collections.sort(pumps);
        File filePumps = new File(fileWithPumps);

        try {
            objectMapper.writeValue(filePumps, pumps);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<PumpRequest> pumpRequests = new ArrayList<>();
        PumpRequest pumpRequest = new PumpRequest(1.0, 64.0);
        pumpRequests.add(pumpRequest);

        PumpPackageSelector pumpPackageSelector = new PumpPackageSelector(filePumps);
        pumpPackageSelector.getPumpReport(pumpRequests, fileReport);


        PumpReport pumpReport = objectMapper.readValue(fileReport, PumpReport.class);

        List<PumpTechResponse> pumpTechResponses = pumpReport.getPumpTechResponses();
        pumpTechResponses.forEach(Assert::assertNotNull);
        assertEquals(pumpTechResponses.size(), 1);

        PumpCommercialBlock commercialBlock = pumpReport.getCommercialBlock();
        assertEquals(pumps.get(0), pumpReport.getPumpTechResponses().get(0).getPumpOrNull());
        assertEquals(pumps.get(0).getRublePrice(), commercialBlock.getPriceInTotal());
        Double onePumpWithDelivery = pumps.get(0).getRublePrice() * 1.1;
        assertEquals(onePumpWithDelivery, commercialBlock.getPriceWithDelivery());

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