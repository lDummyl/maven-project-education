package task7.pump;


import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Pump implements Comparable<Pump> {
    private String model;
    private Price price;


    private List<Speed> speeds = new ArrayList<>();

    public Pump(String model, Double[] consumption, Double[] pressure, Double price) {
        this.model = model;
        this.speeds.add(new Speed(consumption, pressure));
        this.price = new Price(price);
    }

    @Override
    public int compareTo(Pump o) {
        return this.price.compareTo(o.price);
    }

}
