package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import task7.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

            // TODO: 10/14/19 try-catch-driven-development  это не самая лучшая методология
            //  логика в задании немного другая. Не фиксировать сколько ошибок было сделано
            //  а каждый подбор должен содеражть инфу примерный он или точный. Если данных нет, например пришел расход 10 а напор "хз" итаких 3 штуки
            //  нужно дать бюджет, подобрать исходя из того например что есть известных 29 насоаов корректно подобранных, и нужно дать еще один. Можно просто поделить сумму 29 на их
            //  кол-во и добавить среднее. Можно получив среднюю сумму подобрать модель, ближайшую к этой сумме. Можно учитывать или нет параметры котоыре есть, например если подобранный не выдаст 10
            //  ни при каком давлении подбирать пока не будет хотябы по нижней границе.
            //  но так или иначе задача дать максимально реальный бюджет и предупередить, что этот насос подобран в усовиях отсутствия точных данных исходя их среденй величины.
            //  когда дойдет до реального закупа, они уточнят или купят не глядя, но у тебя булет дисклеймер. Задача в этом короче к ней можно по разному подойти, но главное
            //  дать КП во что бы то ни стало, бытро чтобы уже предметно потом его уточнять.

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

    // TODO: 10/14/19 прочтитай про type erasure технически компилятор полиморфизм в рантайме используется, а в компаилтайме информация в угловых скобках стирается поэтому и там и там List
    //  что с этим делать Заведи разные классы, классов много не бывает если они понятные и не большие, и из названия следует их Single responsibility.

    class PumpBatchRequest{
        LocalDateTime created;
        List<Pair> pairs;
    }
    class PumpBatchRequestsArchive{
        LocalDateTime firstCreated;
        LocalDateTime lastCreated;
        Integer pairsOverall;
        List<PumpBatchRequest> requests;

        public int getPairsOverall() {
            Optional<Integer> qty = requests.stream().flatMap(Stream::of).map(i -> i.pairs.size()).reduce(Integer::sum);
            return qty.orElse(0);
        }
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
