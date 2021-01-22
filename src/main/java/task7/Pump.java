package task7;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import task6.LagrangePolynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@Getter
@Setter
public class Pump implements Comparable<Pump> {
    private String model;
    private Price price; // TODO: 19.01.2021 заведи класс Price


    private List<Speed> speeds = new ArrayList<>();

    public Pump(String model, Double[] consumption, Double[] pressure, Double price) {
        this.model = model;
        this.speeds.add(new Speed(consumption, pressure));
        this.price = new Price(price);
    }

    public Pump() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pump pump = (Pump) o;
        return Objects.equals(model, pump.model) && Objects.equals(price, pump.price) && Objects.equals(speeds, pump.speeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, speeds);
    }

    public void addSpeed(Double[] consumption, Double[] pressure) {
        this.speeds.add(new Speed(consumption, pressure));
    }

    @Override
    public int compareTo(Pump o) {
        return this.price.compareTo(o.price);
    }

}
