package task10;


import newpumpbutchselector.CirculationPumpBatchReport;
import newpumpbutchselector.CirculationPumpResponse;
import newpumpselector.CirculationPumpSelectorException;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
	Модифицировать генератор запросов чтобы создать эмулятор запросов на год
	добавить в запросы и резульататы дату. Сгенерировать 100 запросов,
	с некорорым распредением по году
	выдать отчет по этим отчетам сколько куплено по месяцам, всего за год, среднее в мес
	всего за доставку затраты, сколько в месяц ошибок в данных.

 */

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.stream.Stream;


// TODO: 16.01.2021 переползай не lombok
@Getter
@Setter
public class GeneralPumpReport {
    private List<CirculationPumpBatchReport> reports;
    private Map<Month, Integer> purchasesPerMonth;
    private Integer perYearInTotal;
    private Double averagePerMonth;
    private Double totalForDelivery;
    private Map<Month, Integer> errorsPerMonth;

    public GeneralPumpReport(List<CirculationPumpBatchReport> reports) {
        this.reports = reports;
        this.averagePerMonth = calculateAveragePerMonth();
        this.perYearInTotal = calculatePerYear();
        this.errorsPerMonth = calculateMonthErrors();
        this.totalForDelivery = calculateTotalFoeDelivery();
        this.purchasesPerMonth = calculatePurchasesPerMonth();
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

    private List<CirculationPumpResponse> getAllResponses(){
       return reports.stream().map(CirculationPumpBatchReport::getResponses).flatMap(Collection::stream).collect(Collectors.toList());
    }


    private Double calculateTotalFoeDelivery() {
        double sum = reports.stream().map(value -> value.getCommercialBLock().getPriceInTotal() - value.getCommercialBLock().getPriceWithoutDelivery())
                .mapToDouble(Double::valueOf).sum();
        return Math.floor(sum);
    }

    public GeneralPumpReport() {
    }

    private Integer calculatePerYear() {
        return reports.stream().map(CirculationPumpBatchReport::getResponses).map(Collection::size).mapToInt(Integer::valueOf).sum();
    }

    private Double calculateAveragePerMonth() {
        double sum = reports.stream().map(CirculationPumpBatchReport::getResponses)
                .map(Collection::size)
                .mapToDouble(Double::valueOf).sum();
        return Math.floor(sum / 12);
    }
}
