package task10;

import java.util.Map;

public class GeneralPumpReport {
    private Map<Integer, Integer> purshuasesProMonth;
    private int totalProYear;
    Double  averagePerMonth;
    private Double totalForDelivery;
    private Integer errorInDataPerMonth;

    public GeneralPumpReport(Map<Integer, Integer> purshuasesProMonth, int totalProYear, Double averagePerMonth, Double totalForDelivery, Integer errorInDataPerMonth) {
        this.purshuasesProMonth = purshuasesProMonth;
        this.totalProYear = totalProYear;
        this.averagePerMonth = averagePerMonth;
        this.totalForDelivery = totalForDelivery;
        this.errorInDataPerMonth = errorInDataPerMonth;
    }

    public Map<Integer, Integer> getPurshuasesProMonth() {
        return purshuasesProMonth;
    }

    public void setPurshuasesProMonth(Map<Integer, Integer> purshuasesProMonth) {
        this.purshuasesProMonth = purshuasesProMonth;
    }

    public int getTotalProYear() {
        return totalProYear;
    }

    public void setTotalProYear(int totalProYear) {
        this.totalProYear = totalProYear;
    }

    // FIXME: 1/12/2021 сделать суммы покупок
    public Double getAveragePerMonth() {
        return averagePerMonth;
    }

    public void setAveragePerMonth(Double averagePerMonth) {
        this.averagePerMonth = averagePerMonth;
    }

    public Double getTotalForDelivery() {
        return totalForDelivery;
    }

    public void setTotalForDelivery(Double totalForDelivery) {
        this.totalForDelivery = totalForDelivery;
    }

    public Integer getErrorInDataPerMonth() {
        return errorInDataPerMonth;
    }

    public void setErrorInDataPerMonth(Integer errorInDataPerMonth) {
        this.errorInDataPerMonth = errorInDataPerMonth;
    }
}
