package task10;

import newpumpbutchselector.CirculationPumpBatchReport;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RequestSimulatorTest {

    @Test
    public void simulationTest(){
        RequestSimulator requestSimulator = new RequestSimulator();
        Integer numberOfReports = 10;
        int numberOfRequests = 7;


        List<CirculationPumpBatchReport> simulate = requestSimulator.simulate(numberOfReports, numberOfRequests);
        GeneralPumpReport generalPumpReport = new GeneralPumpReport();
        System.out.println();
    }

}