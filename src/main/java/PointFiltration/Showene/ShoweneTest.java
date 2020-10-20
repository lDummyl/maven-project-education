package PointFiltration.Showene;

import java.util.Collection;
import java.util.List;

public class ShoweneTest implements Ranger {
    List<Double> processingData;
    List<Double> processedData;

    @Override
    public AcceptableRange getRange(Collection inputs) {
        List<Double> in = (List<Double>) inputs;
        LeftAndRight lr = new LeftAndRight(in);
        Medians medians = new Medians(lr.getLefts(), lr.getRights());
        Double iQr = medians.getMedianRight() - medians.getMedianLeft();
        AcceptableRange<Number> numberAcceptableRange = new AcceptableRange<>();
        return null;
    }
}
