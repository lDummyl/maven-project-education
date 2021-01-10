package task10;

import org.junit.Test;
import task8.PumpPackageSelector;
import task8.PumpReport;
import task8.PumpRequest;
import task8.PumpTechResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GeneralPumpReportProviderTest {
    @Test
    public void generalReportTest() {
        List<PumpRequest> requestsFirst = Arrays.asList(new PumpRequest(0.9, 2.9, LocalDate.of(2021, 3, 3)),
                new PumpRequest(null, 2.9, LocalDate.of(2021, 4, 4)));

        List<PumpRequest> requestsSecond = Arrays.asList(new PumpRequest(0.9, 2.9, LocalDate.of(2021, 5, 3)),
                new PumpRequest(0.9, 2.9, LocalDate.of(2021, 6, 4)));


        PumpPackageSelector selector = new PumpPackageSelector();

        PumpReport pumpReport = selector.selectPumpsWithReport(requestsFirst);
        PumpReport pumpReport1 = selector.selectPumpsWithReport(requestsSecond);

        List<PumpReport> pumpReports = Arrays.asList(pumpReport1, pumpReport);

        GeneralPumpReportProvider generalPumpReportProvider = new GeneralPumpReportProvider(pumpReports);

        GeneralPumpReport report = generalPumpReportProvider.createReport();

        Double pumpPrice = 104.0;
        Double deliveryPrice = roundOf((pumpPrice * 3 * 1.1) - (pumpPrice*3)) ;


        assertEquals(3, report.getTotalProYear());
        // FIXME: 1/10/2021 не то считает
       // assertEquals(report.getErrorInDataPerMonth());
        assertEquals(3,report.getTotalProYear());
        assertEquals(roundOf(3.0/12.0) ,report.averagePerMonth);
        assertEquals(deliveryPrice, roundOf(report.getTotalForDelivery()));

    }
    private Double roundOf(Double value){
        return (double) Math.round(value * 100) / 100;
    }
}