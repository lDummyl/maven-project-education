package task10;


import lombok.Getter;
import lombok.Setter;
import newpumpbutchselector.CirculationPumpBatchReport;

import java.time.Month;
import java.util.Collection;
import java.util.List;
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
        // TODO: 19.01.2021 по взрослому не принято вызывать методы в конструкторе, в нем просто присвоение полям значений. Такой отчет лучше все-таки не пытаться сделать шибко ООПшным. Сделай службу их формирующую, а отчет просто как dto, которые он выдает.
        this.averagePerMonth = calculateAveragePerMonth();
        this.perYearInTotal = calculatePerYear();
        this.errorsPerMonth = calculateMonthErrors();
        this.totalForDelivery = calculateTotalFoeDelivery();
        this.purchasesPerMonth = calculatePurchasesPerMonth();
    }
    // TODO: 1/18/2021 Реализовать по мемяцам
    private Map<Month, Integer> calculatePurchasesPerMonth() {
        // TODO: 19.01.2021 не оставляй в коммитах мертвый код учись привыкай работать с VCS и если что-то не готово лучше бросать ex, чем возвращать null.
        return null;
    }

    private Double calculateTotalFoeDelivery() {
        return reports.stream().map(value -> value.getCommercialBLock().getPriceInTotal() - value.getCommercialBLock().getPriceWithoutDelivery())
                .mapToDouble(Double::valueOf).sum();
    }

    // TODO: 1/18/2021 Реализовать по мемяцам
    private Map<Month, Integer> calculateMonthErrors() {
        return null;
    }

    public GeneralPumpReport() {
    }

    private Integer calculatePerYear() {
        return reports.stream().map(CirculationPumpBatchReport::getResponses).map(Collection::size).mapToInt(Integer::valueOf).sum();
    }

    // TODO: 19.01.2021 а теперь сделай отчет по месяцам со средним КП по сумме в каждом месяце.
    private Double calculateAveragePerMonth() {
        double sum = reports.stream().map(CirculationPumpBatchReport::getResponses)
                .map(Collection::size)
                .mapToDouble(Double::valueOf).sum();
        return sum / 12;
    }
}
