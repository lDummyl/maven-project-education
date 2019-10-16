package task9;

import org.junit.Test;
import task8.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class ReportConstructorTest {

    Logger log = Logger.getLogger(ReportConstructor.class.getName());
    Converter converter = new Converter();

    private PumpBatchRequestsArchive getRequests(int qty, LocalDateTime created) {
        PumpBatchRequestsArchive pumpBatchRequestsArchive = new PumpBatchRequestsArchive(
                LocalDateTime.now().minusMonths(1), LocalDateTime.now(), qty);
        for (int i = 0; i < qty; i++) {
            PumpBatchRequest pumpBatchRequest = new PumpBatchRequest(LocalDateTime.now());
            pumpBatchRequest.created = created;
            pumpBatchRequest.pairs = Arrays.asList(new Pair(4., 26.), new Pair(10., 45.));
        }
        return pumpBatchRequestsArchive;
    }

    @Test
    public void reportStringsListTest () {
        ReportConstructor reportConstructor = new ReportConstructor(70.);
        PumpBatchRequestsArchive pumpBatchRequestsArchive = getRequests(20, LocalDateTime.now());

        List<String> reports = reportConstructor.generateReports(pumpBatchRequestsArchive);

        for (String report : reports) {
            assertTrue(report.contains("GHN 25/40-130"));
        }
    }

    @Test
    public void reportStringsTest () {
        ReportConstructor reportConstructor = new ReportConstructor(70.);
        PumpBatchRequestsArchive pumpBatchRequestsArchive = getRequests(20, LocalDateTime.now());

        List<String> jsonList = new ArrayList<>();
        pumpBatchRequestsArchive.requests.forEach(i -> jsonList.add(converter.getStringJSON(i)));
        List<String> reports = reportConstructor.generateReports(jsonList);

        for (String report : reports) {
            assertTrue(report.contains("GHN 25/40-130"));
        }
    }
}