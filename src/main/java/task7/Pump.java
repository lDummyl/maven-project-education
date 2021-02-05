package task7;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Pump implements Comparable<Pump> {
    private String model;
    private Price price;


    private List<Speed> speeds = new ArrayList<>();

    public Pump(String model, Double[] consumption, Double[] pressure, Double price) {
        this.model = model;
        this.speeds.add(new Speed(consumption, pressure));
        this.price = new Price(price);
    }


    public void addSpeed(Double[] consumption, Double[] pressure) {
        this.speeds.add(new Speed(consumption, pressure));
    }

    @Override
    public int compareTo(Pump o) {
        return this.price.compareTo(o.price);
    }

}
