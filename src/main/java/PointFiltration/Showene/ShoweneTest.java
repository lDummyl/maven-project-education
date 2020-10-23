package PointFiltration.Showene;

import java.util.Collection;
import java.util.List;

public class ShoweneTest  {
    List<Double> processingData;
    List<Double> processedData;


    public AcceptableRange getData(Collection inputs) {
        List<Double> in = (List<Double>) inputs;
        LeftAndRight lr = new LeftAndRight(in);
        Medians medians = new Medians(lr.getLefts(), lr.getRights());
        Double iQr = medians.getMedianRight() - medians.getMedianLeft();
//        AcceptableRange<Number> numberAcceptableRange = new AcceptableRange<>();

        return null;
    }
}
