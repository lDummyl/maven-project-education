package task8;

import lombok.Getter;
import task7.PumpIMP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class CommercialUnit {

    private Map<PumpIMP, Double> priceList = new HashMap<>();
    private Integer countPositions;
    private Double sumPositions;
    private Double delivery = 0.;

    public CommercialUnit(List<PumpIMP> pumps) {
        fillPriceList(pumps);
        totalPriceList(pumps);
        calculateShipping();
    }

    private void fillPriceList(List<PumpIMP> pumps) {
        for (PumpIMP pump : pumps) {
            Double price = 0.;
            if (priceList.containsKey(pump)) {
                price = priceList.get(pump);
            }
            priceList.put(pump, pump.getPrice() + price);
        }
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