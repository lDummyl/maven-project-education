package task10;


import newpumpbutchselector.CirculationPumpBatchReport;
import newpumpbutchselector.CirculationPumpResponse;
import newpumpselector.CirculationPumpSelectorException;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
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
    // TODO: 1/18/2021 Реализовать по мемяцам
    private Map<Month, Integer> calculatePurchasesPerMonth() {
        /*HashMap<Month, Integer> purchasesPerMonth = new HashMap<>();
        List<Collection<CirculationPumpResponse>> collect = reports.stream().map(CirculationPumpBatchReport::getResponses).collect(Collectors.toList());
        for (Collection<CirculationPumpResponse> responses : collect) {
            for (CirculationPumpResponse respons : responses) {
                LocalDate currentDate = respons.getRequest().getDateTime();
                Integer currentValue = purchasesPerMonth.get(currentDate.getMonth());
                purchasesPerMonth.put(currentDate.getMonth(), currentValue + 1);
            }
        }*/
        return null;
    }

    private Double calculateTotalFoeDelivery() {
        return reports.stream().map(value -> value.getCommercialBLock().getPriceInTotal() - value.getCommercialBLock().getPriceWithoutDelivery())
                .mapToDouble(Double::valueOf).sum();
    }

    // TODO: 1/18/2021 Реализовать по мемяцам
    private Map<Month, Integer> calculateMonthErrors() {
        /*HashMap<Month, Integer> errorsPerMonth = new HashMap<>();

        List<Collection<CirculationPumpResponse>> responseCollection = reports.stream().map(CirculationPumpBatchReport::getResponses).collect(Collectors.toList());
        for (Collection<CirculationPumpResponse> responses : responseCollection) {
            for (CirculationPumpResponse respons : responses) {
                LocalDate dateTime = respons.getRequest().getDateTime();
                CirculationPumpSelectorException error = respons.getError();
                if (error != null || dateTime != null) {
                    Month currentMonth = dateTime.getMonth();
                    Integer currentValue = errorsPerMonth.get(currentMonth);
                    errorsPerMonth.put(currentMonth, currentValue + 1);
                }
            }
        }*/
        return null;
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
        return sum / 12;
    }
}
