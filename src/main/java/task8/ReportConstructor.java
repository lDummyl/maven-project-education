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

            // TODO: 10/14/19 try-catch-driven-development  это не самая лучшая методология
            //  логика в задании немного другая. Не фиксировать сколько ошибок было сделано
            //  а каждый подбор должен содеражть инфу примерный он или точный. Если данных нет, например пришел расход 10 а напор "хз" итаких 3 штуки
            //  нужно дать бюджет, подобрать исходя из того например что есть известных 29 насоаов корректно подобранных, и нужно дать еще один. Можно просто поделить сумму 29 на их
            //  кол-во и добавить среднее. Можно получив среднюю сумму подобрать модель, ближайшую к этой сумме. Можно учитывать или нет параметры котоыре есть, например если подобранный не выдаст 10
            //  ни при каком давлении подбирать пока не будет хотябы по нижней границе.
            //  но так или иначе задача дать максимально реальный бюджет и предупередить, что этот насос подобран в усовиях отсутствия точных данных исходя их среденй величины.
            //  когда дойдет до реального закупа, они уточнят или купят не глядя, но у тебя булет дисклеймер. Задача в этом короче к ней можно по разному подойти, но главное
            //  дать КП во что бы то ни стало, бытро чтобы уже предметно потом его уточнять.

            PumpIMP pump;
            try {
                pump = pumpSelectorSquare.select(flow, pressure);
            } catch (PumpNotSelectedException ex) {
                Double avgPrice = getAVGPrice(pumps);
                pump = pumpSelectorSquare.selectPumpAVGPrice(avgPrice);
//                ErrorMessage message = ex.getErrorMessage();
//                if (message != null && message == ErrorMessage.NOT_FOUND) {
                    errors++;
//                }
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
        //List<Pair> pairs = mapper.readValue(jsonBody, new TypeReference<List<Pair>>() {});
        PumpBatchRequest pumpBatchRequest = mapper.readValue(jsonBody, PumpBatchRequest.class);
        return generateSelectionReport(pumpBatchRequest);
    }

    public String generateReport(PumpBatchRequest pumpBatchRequest) {
        SelectionReport selectionReport = generateSelectionReport(pumpBatchRequest);
        return getReport(selectionReport);
    }

    @SneakyThrows
    public String generateReport(String jsonBody) {
        //List<Pair> pairs = mapper.readValue(jsonBody, new TypeReference<List<Pair>>() {});
        PumpBatchRequest pumpBatchRequest = mapper.readValue(jsonBody, PumpBatchRequest.class);
        return generateReport(pumpBatchRequest);
    }

    @SneakyThrows
    private String getReport(SelectionReport selectionReport) {
        return selectionReport != null ? mapper.writeValueAsString(selectionReport) : "";
    }

    // TODO: 10/14/19 прочтитай про type erasure технически компилятор полиморфизм в рантайме используется, а в компаилтайме информация в угловых скобках стирается поэтому и там и там List
    //  что с этим делать Заведи разные классы, классов много не бывает если они понятные и не большие, и из названия следует их Single responsibility.

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
