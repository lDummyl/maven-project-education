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

    public GeneralPumpReport() {
    }
}
