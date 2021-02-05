package task10;


import lombok.NoArgsConstructor;
import newpumpbutchselector.CirculationPumpBatchReport;

import java.time.Month;
import java.util.*;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class GeneralPumpReport {
    private List<CirculationPumpBatchReport> reports;
    private Map<Month, Integer> purchasesPerMonth;
    private Integer perYearInTotal;
    private Double averagePerMonth;
    private Double totalForDelivery;
    private Map<Month, Integer> errorsPerMonth;
}
