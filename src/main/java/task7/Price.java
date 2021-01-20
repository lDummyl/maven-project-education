package task7;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price implements Comparable<Price>{
    private Double rublePrice;

    public Price(Double rublePrice) {
        this.rublePrice = rublePrice;
    }

    public Price() {
    }

    @Override
    public int compareTo(Price o) {
        return this.rublePrice.compareTo(o.rublePrice);
    }
}
