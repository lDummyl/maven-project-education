package task10;

import org.junit.Test;

import task8.PumpPackageSelector;
import task8.PumpReport;
import task8.RequestGenerator;
import static org.junit.Assert.*;
import java.util.List;


public class MainTest {
    GeneralPumpReport generalPumpReport;
    RequestGenerator requestGenerator = new RequestGenerator();
    PumpPackageSelector selector = new PumpPackageSelector();

    @Test
    public void generalReportTest(){
        DatePumpRequestGenerator generator = new DatePumpRequestGenerator();

        DateWorkSimulation dateWorkSimulation = new DateWorkSimulation();
        List<PumpReport> simulatedReports = dateWorkSimulation.simulate();

        GeneralPumpReportProvider generalPumpReportProvider = new GeneralPumpReportProvider(simulatedReports);
        GeneralPumpReport report = generalPumpReportProvider.createReport();

        assertNotNull(report.getAveragePerMonth());
        assertNotNull(report.getErrorInDataPerMonth());
        assertNotNull(report.getPurshuasesProMonth());
        assertNotNull(report.getTotalProYear());
        assertNotNull(report.getTotalForDelivery());

    }

}