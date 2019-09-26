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

    {
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
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

            Double workPoint = 20.; // временный костыль)
            selectionReport.technicalUnits.add(new TechnicalUnit(pump, pressure, flow, workPoint));
        }

        selectionReport.commercialUnit = new CommercialUnit(pumps);
    }

    @SneakyThrows
    public void generateReport(String jsonBody) {
        List<Pair> pairs = mapper.readValue(jsonBody, new TypeReference<List<Pair>>() {});
        generateReport(pairs);
    }

    @SneakyThrows
    public String getReportString() {
        if (selectionReport != null) {
            return mapper.writeValueAsString(selectionReport);
        }
        return "";
    }

    public SelectionReport getSelectionReport() {
        return selectionReport;
    }

    public void setSelectionReport(SelectionReport selectionReport) {
        this.selectionReport = selectionReport;
    }
}
