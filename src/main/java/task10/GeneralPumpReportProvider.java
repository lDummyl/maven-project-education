
package task10;

import newpumpbutchselector.CirculationPumpBatchReport;
import newpumpbutchselector.CirculationPumpResponse;


import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;


public class GeneralPumpReportProvider {
    private List<CirculationPumpBatchReport> reports;

    public GeneralPumpReportProvider(List<CirculationPumpBatchReport> reports) {
        this.reports = reports;
    }

    public GeneralPumpReport getReport() {
        GeneralPumpReport generalPumpReport = new GeneralPumpReport();
        generalPumpReport.setReports(reports);
        generalPumpReport.setAveragePerMonth(calculateAveragePerMonth());
        generalPumpReport.setErrorsPerMonth(calculateMonthErrors());
        generalPumpReport.setPerYearInTotal(calculatePerYear());
        generalPumpReport.setPurchasesPerMonth(calculatePurchasesPerMonth());
        generalPumpReport.setTotalForDelivery(calculateTotalFoeDelivery());
        return generalPumpReport;
    }

    private Map<Month, Integer> calculateMonthErrors() {
        HashMap<Month, Integer> monthErrors = new HashMap<>();
        List<CirculationPumpResponse> onlyErrorsList = getAllResponses().stream().filter(value -> value.getError() != null).collect(Collectors.toList());

        return createMonthMapWithNumberOfElements(onlyErrorsList);
    }

    private Map<Month, Integer> createMonthMapWithNumberOfElements(List<CirculationPumpResponse> responses) {
        HashMap<Month, Integer> monthMap = new HashMap<>();

        for (CirculationPumpResponse response : responses) {
            Month currentMonth = response.getRequest().getDateTime().getMonth();
            monthMap.putIfAbsent(currentMonth, 0);
            monthMap.put(currentMonth, monthMap.get(currentMonth) + 1);
            System.out.println();
        }
        return monthMap;
    }

    private Map<Month, Integer> calculatePurchasesPerMonth() {
        List<CirculationPumpResponse> onlyByedList = getAllResponses().stream().filter(value -> value.getPump().isPresent()).collect(Collectors.toList());

        return createMonthMapWithNumberOfElements(onlyByedList);
    }

    private List<CirculationPumpResponse> getAllResponses() {
        return reports.stream().map(CirculationPumpBatchReport::getResponses).flatMap(Collection::stream).collect(Collectors.toList());
    }


    private Double calculateTotalFoeDelivery() {
        double sum = reports.stream().map(value -> value.getCommercialBLock().getPriceInTotal() - value.getCommercialBLock().getPriceWithoutDelivery())
                .mapToDouble(Double::valueOf).sum();
        return Math.floor(sum);
    }


    private Integer calculatePerYear() {
        return reports.stream().map(CirculationPumpBatchReport::getResponses).map(Collection::size).mapToInt(Integer::valueOf).sum();
    }

    private Double calculateAveragePerMonth() {

        double sum = getAllResponses().stream().filter(value -> value.getPump().isPresent())
                .map(value -> value.getPump().get().getPrice().getRublePrice())
                .mapToDouble(Double::doubleValue).sum();
        return sum / 12;
    }
}

