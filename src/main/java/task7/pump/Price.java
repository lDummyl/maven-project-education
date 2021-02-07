package task7.pump;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Price implements Comparable<Price> {
    private Double rublePrice;

    public Price(Double rublePrice) {
        this.rublePrice = rublePrice;
    }

    @Override
    public int compareTo(Price o) {
        return this.rublePrice.compareTo(o.rublePrice);
    }
}
