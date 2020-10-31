package SortingExperiment;

import lombok.Data;

@Data
public class Temperature implements Comparable<Temperature>{
    Double celsiusValue;

    public Temperature(Double celsiusValue) {
        this.celsiusValue = celsiusValue;
    }

    @Override
    public int compareTo(Temperature o) {
        return celsiusValue.compareTo(o.celsiusValue);
    }

}