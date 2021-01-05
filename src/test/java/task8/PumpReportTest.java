package task8;

import org.junit.Assert;
import org.junit.Test;
import task7.Pump;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PumpReportTest {
    @Test
    public void techPartTestOneRequest(){
        List<Pump> pumps = CollectionPump.addPumps();
        List<PumpRequest> pumpRequestList = new ArrayList<>();
        pumpRequestList.add(new PumpRequest(1.0,64.0));
        PumpReport pumpReport = new PumpReport(pumps, pumpRequestList);
        List<PumpTechResponse> pumpTechResponses = pumpReport.getPumpTechResponses();
        PumpTechResponse pumpTechResponse = pumpTechResponses.get(0);


        assertEquals(pumps.get(0), pumpTechResponse.getPumpOrNull());
    }
    @Test
    public void techPartTestNoSuitable(){
        List<Pump> pumps = CollectionPump.addPumps();
        List<PumpRequest> pumpRequestList = new ArrayList<>();
        pumpRequestList.add(new PumpRequest(1000.0,2000.0));
        PumpReport pumpReport = new PumpReport(pumps, pumpRequestList);
        List<PumpTechResponse> pumpTechResponses = pumpReport.getPumpTechResponses();
        PumpTechResponse pumpTechResponse = pumpTechResponses.get(0);

        assertNull(pumpTechResponse.getPumpOrNull());
    }
    @Test
    public void techPartTestGeneratedResponses(){
        RequestGenerator requestGenerator = new RequestGenerator();
        List<Pump> pumps = CollectionPump.addPumps();

        List<PumpRequest> pumpRequestList = requestGenerator.generateRequests(1000);
        PumpReport pumpReport = new PumpReport(pumps, pumpRequestList);

        pumpReport.getPumpTechResponses().forEach(Assert::assertNotNull);
    }
    @Test
    public void commercialPartTest(){
        RequestGenerator requestGenerator = new RequestGenerator();
        List<Pump> pumps = CollectionPump.addPumps();

        List<PumpRequest> pumpRequestList = requestGenerator.generateRequests(1000);
        PumpReport pumpReport = new PumpReport(pumps, pumpRequestList);

        assertTrue(pumpReport.getCommercialBlock().priceInTotal > 0);
        assertEquals(pumps.size(), pumpReport.getCommercialBlock().getUniquePumps().size());

    }

}