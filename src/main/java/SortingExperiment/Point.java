package SortingExperiment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class Point implements Comparable<Point> {
    Integer code;
    Temperature temperature;
    Freq frequency;

    public Point(String allPoints) {
        String[] split = allPoints.split(",");

        this.code = (Integer.parseInt(split[0].replaceAll("\\s+", "")));
        this.temperature =  new Temperature(Double.parseDouble(split[1].replaceAll("\\s+", "")));
        this.frequency = new Freq(Double.parseDouble(split[2].replaceAll("\\s+", "")));
    }

    public Freq getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(Point o) {
        return this.code.compareTo(o.code) * 10 + this.temperature.compareTo(o.temperature);
    }

    @Override
    public String toString() {
        return "Point{" +
                "code=" + code +
                ", temperature=" + temperature +
                ", frequency=" + frequency +
                '}';
    }
}

