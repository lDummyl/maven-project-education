package task10;

import task8.PumpReport;
import task8.PumpTechResponse;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
	Модифицировать генератор запросов чтобы создать эмулятор запросов на год
	добавить в запросы и резульататы дату. Сгенерировать 100 запросов,
	с некорорым распредением по году
	выдать отчет по этим отчетам сколько куплено по месяцам, всего за год, среднее в мес
	всего за доставку затраты, сколько в месяц ошибок в данных.

 */

public class GeneralPumpReportProvider {
    File fileWithReports;
    List<PumpReport> pumpReportList;


    public GeneralPumpReportProvider(List<PumpReport> pumpReportList) {
        this.pumpReportList = pumpReportList;
    }

    public GeneralPumpReport createReport() {
        Map<Integer, Integer> purshuasesProMonth = getPurshuasesProMonth();
        int totalProYear = getTotalProYear(purshuasesProMonth);
        Double averagePerMonth = averagePerMonth(totalProYear);
        Double totalForDelivery = getTotalForDelivery();
        Integer errorInDataPerMonth = getErrorInDataPerMonth();
        return new GeneralPumpReport(purshuasesProMonth, totalProYear, averagePerMonth, totalForDelivery, errorInDataPerMonth);
    }

    private int getTotalProYear(Map<Integer, Integer> purshuasesProMonth) {
        int sum = 0;
        for (Integer value : purshuasesProMonth.values()) {
            sum += value;
        }
        return sum;
    }

    private Integer getErrorInDataPerMonth() {
        int errorsInTotal = 0;
        for (PumpReport pumpReport : pumpReportList) {
            for (PumpTechResponse pumpTechRespons : pumpReport.getPumpTechResponses()) {
                Double consumption = pumpTechRespons.getRequest().getConsumption();
                Double pressure = pumpTechRespons.getRequest().getPressure();
                if (consumption == null || pressure == null) {
                    errorsInTotal++;
                }
            }
        }
        return errorsInTotal;
    }

    private Double getTotalForDelivery() {
        Double totalForDelivery = 0.0;
        for (PumpReport pumpReport : pumpReportList) {
            Double priceWithDelivery = pumpReport.getCommercialBlock().getPriceWithDelivery();
            Double priceInTotal = pumpReport.getCommercialBlock().getPriceInTotal();
            totalForDelivery += priceWithDelivery - priceInTotal;
        }
        return roundOf(totalForDelivery);
    }

    private Double averagePerMonth(int totalProYear) {
        return roundOf( totalProYear / 12.0);
    }

    private Map<Integer, Integer> getPurshuasesProMonth() {
//        Month august = Month.AUGUST;
//        int numVal = august.getValue();
//        Month feb = Month.of(2);
//        EnumMap<Month, Integer> qtyPerMonth;
//        но я бы сделал сисок EnumMap<Month, Set<PumpReport>> yearlyReport а из него стримами можешь получить все данные что хочешь. Количество, среднее, сумма  и все что хочешь

        HashMap<Integer, Integer> proMonthMap = new HashMap<>();

        for (PumpReport pumpReport : pumpReportList) {
            int monthValue = pumpReport.getDateTime().getMonthValue();
            // TODO: 16.01.2021 делается в одну строчку
//            proMonthMap.merge(monthValue,  pumpReport.getSuccessSelected(), Integer::sum);
            if (proMonthMap.containsKey(monthValue)) {
                Integer currentInMonth = proMonthMap.get(monthValue) + pumpReport.getSuccessSelected();
                proMonthMap.put(monthValue, currentInMonth);
            } else {
                proMonthMap.put(monthValue, pumpReport.getSuccessSelected());
            }
        }
        return proMonthMap;
    }

    // TODO: 16.01.2021 поищи поизящней решение
    private Double roundOf(Double value){
        return (double) Math.round(value * 100) / 100;
    }

}
