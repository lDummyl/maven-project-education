package PointFiltration.Showene;

import java.util.Collection;
import java.util.List;

public class Medians {
    Double medianLeft;
    Double medianRight;

    public Medians(List<Double> lefts, List<Double> rights) {
        this.medianLeft = getMedian(lefts);
        this.medianRight = getMedian(rights);
    }


    public Double getMedianLeft() {
        return medianLeft;
    }

    public Double getMedianRight() {
        return medianRight;
    }

    public Double getMedian(Collection<Double> doubles) {
        Double sum = 0.0;
        for (Double d :
                doubles) {
            sum += d;
        }
        return sum/doubles.size();
    }
}
