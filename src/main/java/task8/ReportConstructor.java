package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import task7.PumpIMP;
import task7.PumpSelectorSquare;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ReportConstructor {

    private ObjectMapper mapper = new ObjectMapper();

    private PumpSelectorSquare pumpSelectorSquare = new PumpSelectorSquare();
    private SelectionReport selectionReport;
    private List<SelectionReport> selectionReports = new ArrayList<>();

    {
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public ReportConstructor(Double ratioPercent) {
        this.pumpSelectorSquare = new PumpSelectorSquare(ratioPercent);
    }

    @SneakyThrows
    public void generateReport(List<Pair> pairs) {
        selectionReport = new SelectionReport();
        List<PumpIMP> pumps = new ArrayList<>();

        for (Pair pair : pairs) {
            Double pressure = pair.getPressure();
            Double flow = pair.getFlow();

            PumpIMP pump = pumpSelectorSquare.select(pressure, flow);
            pumps.add(pump);
            selectionReport.technicalUnits.add(new TechnicalUnit(pump, pressure, flow, pump.getWorkPoint()));
        }

        selectionReport.commercialUnit = new CommercialUnit(pumps);
    }

    @SneakyThrows
    public void generateReport(String jsonBody) {
        List<Pair> pairs = mapper.readValue(jsonBody, new TypeReference<List<Pair>>() {});
        generateReport(pairs);
    }

    public void generateReports(ArrayList<List<Pair>> pairsList) {
        for (List<Pair> pairs : pairsList) {
            generateReport(pairs);
            selectionReports.add(selectionReport);
        }
    }

    public void generateReports(List<String> jsonBodyList) {
        for (String jsonBody : jsonBodyList) {
            generateReport(jsonBody);
            selectionReports.add(selectionReport);
        }
    }

    public String getReportString() {
        return getReport(selectionReport);
    }

    public List<String> getReportStrings() {
        List<String> reports = new ArrayList<>();
        for (SelectionReport report : selectionReports) {
            String reportString = getReport(report);
            if (!reportString.equals("")) {
                reports.add(reportString);
            }
        }
        return reports;
    }

    @SneakyThrows
    private String getReport(SelectionReport selectionReport) {
        return selectionReport != null ? mapper.writeValueAsString(selectionReport) : "";
    }

    public SelectionReport getSelectionReport() {
        return selectionReport;
    }

    public void setSelectionReport(SelectionReport selectionReport) {
        this.selectionReport = selectionReport;
    }
}
