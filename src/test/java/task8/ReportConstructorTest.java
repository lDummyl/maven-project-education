package task8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ReportConstructorTest {

    Logger log = Logger.getLogger(ReportConstructor.class.getName());
    Converter converter = new Converter();
    List<Pair> pairs = Arrays.asList(new Pair(4., 26.), new Pair(10., 45.));

    @Test
    public void generateReportStringTest() {
        ReportConstructor reportConstructor = new ReportConstructor(70.);

        String pairsString = converter.getStringJSON(pairs);
        reportConstructor.generateReport(pairsString);

        SelectionReport selectionReport = reportConstructor.getSelectionReport();
        assertNotNull(selectionReport);
        assertEquals(2, selectionReport.technicalUnits.size());
        assertNotNull(selectionReport.commercialUnit);
    }

    @Test
    public void technicalUnitsTest () {
        ReportConstructor reportConstructor = new ReportConstructor(70.);

        String pairsString = converter.getStringJSON(pairs);
        reportConstructor.generateReport(pairsString);

        List<TechnicalUnit> technicalUnits = reportConstructor.getSelectionReport().technicalUnits;
        for (int i = 0; i < 2; i++) {
            assertEquals(pairs.get(i).getPressure(), technicalUnits.get(i).getPressure());
            assertEquals(pairs.get(i).getFlow(), technicalUnits.get(i).getFlow());
        }
    }

    @Test
    public void commercialUnitTest () {
        ReportConstructor reportConstructor = new ReportConstructor(70.);

        String pairsString = converter.getStringJSON(pairs);
        reportConstructor.generateReport(pairsString);

        CommercialUnit commercialUnit = reportConstructor.getSelectionReport().commercialUnit;

        assertEquals(2, (int) commercialUnit.getCountPositions());
    }

    @Test
    public void reportStringTest () {
        ReportConstructor reportConstructor = new ReportConstructor(70.);

        String pairsString = converter.getStringJSON(pairs);
        reportConstructor.generateReport(pairsString);

        String report = reportConstructor.getReportString();
        assertTrue(report.contains("GHN 25/40-130"));
        assertTrue(report.contains("40000.0"));
    }
}