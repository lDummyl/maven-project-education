package SortingExperiment;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Freq implements Comparable<Freq> {
    Double hzValue;

    public Double getHzValue() {
        return hzValue;
    }

    public Freq(Double hzValue) {
        this.hzValue = hzValue;
    }

    public void setHzValue(Double hzValue) {
        this.hzValue = hzValue;
    }

    @Override
    public int compareTo(Freq o) {
        return hzValue.compareTo(o.hzValue);
    }

    public Double plus(Freq freq) {
        return this.hzValue + freq.hzValue;
    }

    public Double minus(Freq freq) {
        return this.hzValue - freq.hzValue;
    }

}
