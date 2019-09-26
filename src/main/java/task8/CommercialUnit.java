package task8;

import lombok.Getter;
import task7.PumpIMP;

import java.util.List;
import java.util.Map;

@Getter
public class CommercialUnit {

    private Map<PumpIMP, Double> priceList;
    private Integer countPositions;
    private Double sumPositions;
    private Double delivery = 0.;

    public CommercialUnit(List<PumpIMP> pumps) {
        fillPriceList(pumps);
        totalPriceList(pumps);
        calculateShipping();
    }

    private void fillPriceList(List<PumpIMP> pumps) {
        pumps.forEach(i -> priceList.put(i, i.getPrice()));
    }

    private void totalPriceList(List<PumpIMP> pumps) {
        countPositions = pumps.size();
        sumPositions = 0.;
        priceList.values().forEach(i -> sumPositions += i);
    }

    private void calculateShipping() {
        if (sumPositions > 10000.) {
            delivery = sumPositions / 10;
        }
    }
}
