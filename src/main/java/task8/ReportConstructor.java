package task8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import task7.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ReportConstructor {

    private ObjectMapper mapper = new ObjectMapper();

    private PumpSelectorSquare pumpSelectorSquare = new PumpSelectorSquare();

    {
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public ReportConstructor(Double ratioPercent) {
        this.pumpSelectorSquare = new PumpSelectorSquare(ratioPercent);
    }

    public SelectionReport generateSelectionReport(PumpBatchRequest pumpBatchRequest) {
        SelectionReport selectionReport = new SelectionReport();
        List<PumpIMP> pumps = new ArrayList<>();

        int errors = 0;
        for (Pair pair : pumpBatchRequest.pairs) {
            Double flow = pair.getFlow();
            Double pressure = pair.getPressure();

            PumpIMP pump;
            try {
                pump = pumpSelectorSquare.select(flow, pressure);
            } catch (RuntimeExceptionImp ex) {
                Double avgPrice = getAVGPrice(pumps);
                pump = pumpSelectorSquare.selectPumpAVGPrice(avgPrice);
                    errors++;
            }
            pumps.add(pump);
            PumpMinInfo pumpMinInfo = new PumpMinInfo(pump.getName());
            selectionReport.technicalUnits.add(new TechnicalUnit(pumpMinInfo, flow, pressure, pump.getWorkPoint()));
        }
        selectionReport.commercialUnit = new CommercialUnit(pumps);
        selectionReport.errors = errors;

        return selectionReport;
    }

    private Double getAVGPrice(List<PumpIMP> pumps) {
        Double sum = 0.;
        for (PumpIMP pump : pumps) {
            sum += pump.getPrice();
        }
        return getRoundDouble(sum / pumps.size());
    }

    @SneakyThrows
    public SelectionReport generateSelectionReport(String jsonBody) {
        PumpBatchRequest pumpBatchRequest = mapper.readValue(jsonBody, PumpBatchRequest.class);
        return generateSelectionReport(pumpBatchRequest);
    }

    public String generateReport(PumpBatchRequest pumpBatchRequest) {
        SelectionReport selectionReport = generateSelectionReport(pumpBatchRequest);
        return getReport(selectionReport);
    }

    @SneakyThrows
    public String generateReport(String jsonBody) {
        PumpBatchRequest pumpBatchRequest = mapper.readValue(jsonBody, PumpBatchRequest.class);
        return generateReport(pumpBatchRequest);
    }

    @SneakyThrows
    private String getReport(SelectionReport selectionReport) {
        return selectionReport != null ? mapper.writeValueAsString(selectionReport) : "";
    }

    public List<SelectionReport> generateSelectionReports(PumpBatchRequestsArchive pumpBatchRequestsArchive) {
        List<SelectionReport> selectionReports = new ArrayList<>();
        for (PumpBatchRequest pumpBatchRequest : pumpBatchRequestsArchive.requests) {
            SelectionReport selectionReport = generateSelectionReport(pumpBatchRequest);
            selectionReports.add(selectionReport);
        }
        return selectionReports;
    }

    public List<SelectionReport> generateSelectionReports(List<String> jsonBodyList) {
        List<SelectionReport> selectionReports = new ArrayList<>();
        for (String jsonBody : jsonBodyList) {
            SelectionReport selectionReport = generateSelectionReport(jsonBody);
            selectionReports.add(selectionReport);
        }
        return selectionReports;
    }

    public List<String> generateReports(PumpBatchRequestsArchive pumpBatchRequestsArchive) {
        List<SelectionReport> selectionReports = generateSelectionReports(pumpBatchRequestsArchive);
        return getReports(selectionReports);
    }

    public List<String> generateReports(List<String> jsonBodyList) {
        List<SelectionReport> selectionReports = generateSelectionReports(jsonBodyList);
        return getReports(selectionReports);
    }

    private List<String> getReports(List<SelectionReport> selectionReports) {
        List<String> reports = new ArrayList<>();
        for (SelectionReport report : selectionReports) {
            String reportString = getReport(report);
            if (!reportString.equals("")) {
                reports.add(reportString);
            }
        }
        return reports;
    }

    private static Double getRoundDouble(double number) {
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
