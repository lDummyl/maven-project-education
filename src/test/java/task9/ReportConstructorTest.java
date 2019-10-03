package task9;

import org.junit.Test;
import task8.Converter;
import task8.Pair;
import task8.ReportConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class ReportConstructorTest {

    Logger log = Logger.getLogger(ReportConstructor.class.getName());
    Converter converter = new Converter();
    ArrayList<List<Pair>> pairsList = new ArrayList<>();

    @Test
    public void reportStringsListTest () {
        fillPairsList();
        ReportConstructor reportConstructor = new ReportConstructor(70.);

        reportConstructor.generateReports(pairsList);

        List<String> reports = reportConstructor.getReportStrings();
        for (String report : reports) {
            assertTrue(report.contains("GHN 25/40-130"));
            assertTrue(report.contains("40000.0"));
        }
    }

    private void fillPairsList() {
        pairsList.add(Arrays.asList(new Pair(4., 26.), new Pair(10., 45.)));
        pairsList.add(Arrays.asList(new Pair(2., 13.), new Pair(15., 67.5)));
    }

    @Test
    public void reportStringsTest () {
        fillPairsList();
        ReportConstructor reportConstructor = new ReportConstructor(70.);

        List<String> jsonList = new ArrayList<>();
        pairsList.forEach(i -> jsonList.add(converter.getStringJSON(i)));
        reportConstructor.generateReports(jsonList);

        List<String> reports = reportConstructor.getReportStrings();
        for (String report : reports) {
            assertTrue(report.contains("GHN 25/40-130"));
            assertTrue(report.contains("40000.0"));
        }
    }
}