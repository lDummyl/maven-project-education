package task10;


import lombok.NoArgsConstructor;
import task8.report.PumpBatchReport;

import java.time.Month;
import java.util.*;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class GeneralPumpReport {
    private List<PumpBatchReport> reports;
    private Map<Month, Integer> purchasesPerMonth;
    private Integer perYearInTotal;
    private Double averagePerMonth;
    private Double totalForDelivery;
    private Map<Month, Integer> errorsPerMonth;
}
