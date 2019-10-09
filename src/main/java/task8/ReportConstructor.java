package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import task7.*;

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

    public SelectionReport generateSelectionReport(List<Pair> pairs) {
        SelectionReport selectionReport = new SelectionReport();
        List<PumpIMP> pumps = new ArrayList<>();

        int errors = 0;
        for (Pair pair : pairs) {
            Double pressure = pair.getPressure();
            Double flow = pair.getFlow();

            try {
                PumpIMP pump = pumpSelectorSquare.select(pressure, flow);
                pumps.add(pump);
                PumpMinInfo pumpMinInfo = new PumpMinInfo(pump.getName());
                selectionReport.technicalUnits.add(new TechnicalUnit(pumpMinInfo, pressure, flow, pump.getWorkPoint()));
            } catch (PumpNotSelectedException ex) {
                ErrorMessage message = ex.getErrorMessage();
                if (message != null && message == ErrorMessage.NOT_FOUND) {
                    errors++;
                }
            }
        }
        selectionReport.commercialUnit = new CommercialUnit(pumps);
        selectionReport.errors = errors;

        return selectionReport;
    }

    @SneakyThrows
    public SelectionReport generateSelectionReport(String jsonBody) {
        List<Pair> pairs = mapper.readValue(jsonBody, new TypeReference<List<Pair>>() {});
        return generateSelectionReport(pairs);
    }

    public String generateReport(List<Pair> pairs) {
        SelectionReport selectionReport = generateSelectionReport(pairs);
        return getReport(selectionReport);
    }

    @SneakyThrows
    public String generateReport(String jsonBody) {
        List<Pair> pairs = mapper.readValue(jsonBody, new TypeReference<List<Pair>>() {});
        return generateReport(pairs);
    }

    @SneakyThrows
    private String getReport(SelectionReport selectionReport) {
        return selectionReport != null ? mapper.writeValueAsString(selectionReport) : "";
    }

    public List<SelectionReport> generateSelectionReports(ArrayList<List<Pair>> pairsList) {
        List<SelectionReport> selectionReports = new ArrayList<>();
        for (List<Pair> pairs : pairsList) {
            SelectionReport selectionReport = generateSelectionReport(pairs);
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

    public List<String> generateReports(ArrayList<List<Pair>> pairsList) {
        List<SelectionReport> selectionReports = generateSelectionReports(pairsList);
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
}
