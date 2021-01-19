package task10;

import newpumpbutchselector.CirculationPumpBatchReport;
import newpumpbutchselector.CirculationPumpResponse;
import task8.PumpReport;
import task8.PumpTechResponse;

import java.io.File;
import java.time.Month;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
	Модифицировать генератор запросов чтобы создать эмулятор запросов на год
	добавить в запросы и резульататы дату. Сгенерировать 100 запросов,
	с некорорым распредением по году
	выдать отчет по этим отчетам сколько куплено по месяцам, всего за год, среднее в мес
	всего за доставку затраты, сколько в месяц ошибок в данных.

 */

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
        for (CirculationPumpResponse response : onlyErrorsList) {
            Month currentMonth = response.getRequest().getDateTime().getMonth();
            monthErrors.putIfAbsent(currentMonth, 0);
            monthErrors.put(currentMonth, monthErrors.get(currentMonth) + 1);
            System.out.println();
        }
        return monthErrors;
    }

    // FIXME: 1/19/2021 Убрать повторение
    private Map<Month, Integer> calculatePurchasesPerMonth() {
        HashMap<Month, Integer> monthPurchases = new HashMap<>();
        List<CirculationPumpResponse> onlyByedList = getAllResponses().stream().filter(value -> value.getPumpOrNull() != null).collect(Collectors.toList());
        for (CirculationPumpResponse response : onlyByedList) {
            Month currentMonth = response.getRequest().getDateTime().getMonth();
            monthPurchases.putIfAbsent(currentMonth, 0);
            monthPurchases.put(currentMonth, monthPurchases.get(currentMonth) + 1);
            System.out.println();
        }
        return monthPurchases;
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
    //TODO: 19.01.2021 а теперь сделай отчет по месяцам со средним КП по сумме в каждом месяце.
    private Double calculateAveragePerMonth() {
        double sum = reports.stream().map(CirculationPumpBatchReport::getResponses)
                .map(Collection::size)
                .mapToDouble(Double::valueOf).sum();
        return Math.floor(sum / 12);
    }
}
