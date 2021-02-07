package task10;


import task8.report.PumpBatchReport;

import org.junit.Test;

import java.util.List;


public class RequestSimulatorTest {

    @Test
    public void simulationTest() {
        RequestSimulator requestSimulator = new RequestSimulator();
        Integer numberOfReports = 10;
        int numberOfRequests = 7;


        List<PumpBatchReport> simulate = requestSimulator.simulate(numberOfReports, numberOfRequests);
        GeneralPumpReportProvider reportProvider = new GeneralPumpReportProvider(simulate);
        GeneralPumpReport report = reportProvider.getReport();
        System.out.println();
    }
}