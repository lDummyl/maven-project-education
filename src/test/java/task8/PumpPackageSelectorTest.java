package task8;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import task7.Pump;
import task7.PumpCollector;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
        double consumption = 0.94;
        double pressure = 2.6;
        List<PumpRequest> pumpRequestList = Arrays.asList(new PumpRequest(consumption, pressure), new PumpRequest(100.0, 200.0));
        PumpPackageSelector selector = new PumpPackageSelector();
        List<PumpTechResponse> pumps = selector.selectPumps(pumpRequestList);


        assertEquals(pumpRequestList.size(), pumps.size());

        assertTrue(pumps.get(0).getWorkPoint().getPressure() >= pressure);
        assertTrue(pumps.get(0).getWorkPoint().getConsumption() >= consumption);
    }
    @Test
    public void nullRequest(){
        double consumption = 0.94;
        double pressure = 2.6;
        List<PumpRequest> pumpRequestList = Arrays.asList(new PumpRequest(consumption, pressure), new PumpRequest(null, null), new PumpRequest(100.0,200.0));
        PumpPackageSelector selector = new PumpPackageSelector();
        List<PumpTechResponse> pumps = selector.selectPumps(pumpRequestList);


        assertEquals(pumpRequestList.size(), pumps.size());

        assertTrue(pumps.get(0).getWorkPoint().getPressure() >= pressure);
        assertTrue(pumps.get(0).getWorkPoint().getConsumption() >= consumption);
    }
    @Test
    public void reportTechPartTest(){
        double consumption = 0.94;
        double pressure = 2.6;
        List<PumpRequest> pumpRequestList = Arrays.asList(new PumpRequest(consumption, pressure), new PumpRequest(null, null), new PumpRequest(100.0,200.0));
        PumpPackageSelector selector = new PumpPackageSelector();
        PumpReport pumpReport = selector.selectPumpsWithReport(pumpRequestList);
        Integer successSelected = pumpReport.getSuccessSelected();
        Integer expectedSuccess = 1;
        Integer expectedFailed = 2;

        assertEquals(expectedSuccess, successSelected);
        assertEquals(expectedFailed ,pumpReport.getFailSelected());
        List<PumpTechResponse> pumpTechResponses = pumpReport.getPumpTechResponses();

        pumpTechResponses.forEach(Assert::assertNotNull);

        PumpCommercialBlock commercialBlock = pumpReport.getCommercialBlock();
        assertEquals(1, commercialBlock.getUniquePumps().size());

        Double expectedPriceInTotal = 104.0;
        assertEquals(expectedPriceInTotal, commercialBlock.getPriceInTotal());
    }
    @Test
    public void reportCommercialPartTest(){
        double consumption = 0.94;
        double pressure = 2.6;
        List<PumpRequest> pumpRequestList = Arrays.asList(new PumpRequest(consumption, pressure), new PumpRequest(null, null), new PumpRequest(100.0,200.0));
        PumpPackageSelector selector = new PumpPackageSelector();
        PumpReport pumpReport = selector.selectPumpsWithReport(pumpRequestList);


        PumpCommercialBlock commercialBlock = pumpReport.getCommercialBlock();
        assertEquals(1, commercialBlock.getUniquePumps().size());

        Double expectedPriceInTotal = 104.0;
        assertEquals(expectedPriceInTotal, commercialBlock.getPriceInTotal());

        Double expectedPriceWithDelivery = expectedPriceInTotal * 1.1;
        assertEquals(expectedPriceWithDelivery ,commercialBlock.getPriceWithDelivery());
    }
    @Test
    public void priceWithDeliveryTest(){
        double consumption = 0.94;
        double pressure = 2.6;

        List<PumpRequest> pumpRequestList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            pumpRequestList.add(new PumpRequest(consumption, pressure));
        }

        PumpPackageSelector selector = new PumpPackageSelector();
        PumpReport pumpReport = selector.selectPumpsWithReport(pumpRequestList);

        PumpCommercialBlock commercialBlock = pumpReport.getCommercialBlock();

        assertEquals(commercialBlock.getPriceInTotal(), commercialBlock.getPriceWithDelivery());

    }
    @Test
    public void testBatchMany(){
        double consumption = 0.94;
        double pressure = 2.6;

        RequestGenerator requestGenerator = new RequestGenerator();
        List<PumpRequest> pumpRequestList = requestGenerator.generateRequests(100);

        PumpPackageSelector selector = new PumpPackageSelector();
        List<PumpTechResponse> pumps = selector.selectPumps(pumpRequestList);


        assertEquals(pumpRequestList.size(), pumps.size());

       // assertTrue(pumps.get(0).getWorkPoint().getPressure() >= pressure);
       // assertTrue(pumps.get(0).getWorkPoint().getConsumption() >= consumption);
    }

    @Test
    @SneakyThrows
    public void testFilesBatch(){
        File fileWithRequests = new File("RequestFile.json");
        PumpFilePackageSelector selector = new PumpFilePackageSelector();
        File fileWithResponse = selector.selectPumpsToFile(fileWithRequests);

        List<PumpRequest> requests = objectMapper.readValue(fileWithRequests, new TypeReference<List<PumpRequest>>() {
        });
        List<PumpTechResponse>  selectedPupsList = objectMapper.readValue(fileWithResponse, new TypeReference<List<PumpTechResponse>>() {
        });

        assertEquals(requests.size(), selectedPupsList.size());

        for (PumpTechResponse pumpTechResponse : selectedPupsList) {
            assertNotNull(pumpTechResponse);

        }

    }
}