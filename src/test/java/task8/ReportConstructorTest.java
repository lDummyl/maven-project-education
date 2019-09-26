package task8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ReportConstructorTest {

    Logger log = Logger.getLogger(ConverterTest.class.getName());
    Converter converter = new Converter();

    // TODO: 9/26/19 просто внимательно прочитай на что ругается InvalidDefinitionException, сделай что он просит и все булет ок
    @Test
    public void generateReportStringTest() {
        List<Pair> pairs = Arrays.asList(new Pair(4., 7.), new Pair(10., 16.));
        ReportConstructor reportConstructor = new ReportConstructor();

        String pairsString = converter.getStringJSON(pairs);
        reportConstructor.generateReport(pairsString);

        SelectionReport selectionReport = reportConstructor.getSelectionReport();
        assertNotNull(selectionReport);
        assertEquals(2, selectionReport.technicalUnits.size());
        assertNotNull(selectionReport.commercialUnit);
    }
}