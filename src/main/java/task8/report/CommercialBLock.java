package task8.report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task7.pump.Pump;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CommercialBLock {
    private Set<Pump> uniqueModels;
    private Integer uniqueModelsNumber;
    private Double priceInTotal;
    private Double priceWithoutDelivery;
    private Double averagePrice;
}
