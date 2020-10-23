package SortingExperiment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RangerImpl  {


    public AcceptableRange<Double> getRange(Collection<Number> inputs) {
        List<Double> ts = inputs.stream().map(Number::doubleValue).sorted().collect(Collectors.toList());
        List<Double> right = ts.subList(ts.size() / 2, ts.size());
        List<Double> left = ts.subList(0, ts.size() / 2);

        double sumLeft = right.stream().mapToDouble(Number::doubleValue).sum();
        double sumRight = left.stream().mapToDouble(Number::doubleValue).sum();

        double medianLeft = sumLeft/left.size();
        double medianRight = sumRight/right.size();

        double iQR = medianRight - medianLeft;

        Double lower = medianRight + 1.5 * iQR;
        Double upper = medianLeft - 1.5 * iQR;

        return new AcceptableRange<>(upper, lower);
    }


}
