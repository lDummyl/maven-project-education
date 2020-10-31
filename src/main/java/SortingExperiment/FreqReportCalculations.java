package SortingExperiment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FreqReportCalculations {

    public static List<Freq> getLeft(Collection<Freq> d) {
        List<Freq> freqs = new ArrayList<Freq>();
        freqs.addAll(d);
        List<Freq> freqLeft = new ArrayList<Freq>();;
        Collections.sort(freqs);

        for (int i = 0; i < freqs.size() / 2; i++) {
            freqLeft.add(freqs.get(i));
        }
        return freqLeft;
    }

    public static List<Freq> getRight(Collection<Freq> d) {
        List<Freq> freqs = null;
        freqs.addAll(d);
        List<Freq> freqRigth = null;
        Collections.sort(freqs);

        for (int i = 0; i < freqs.size() / 2; i++) {
            freqRigth.add(freqs.get(i));
        }
        return freqRigth;
    }

    public static Freq getMedian(Collection<Freq> d) {
        Freq sum = new Freq((double) 0);
        for (Freq f :
                d) {
            sum.setHzValue(sum.plus(f));
        }
        sum.setHzValue(sum.getHzValue() / d.size());
        return sum;
    }

    public static Freq getIQR(Freq medianRight, Freq medianLeft) {
       Freq iqr = new Freq((double) 0);
       iqr.setHzValue(medianRight.minus(medianRight));
        return iqr;
    }

    public static Freq getUpperFence(Freq medianRight, Freq iqr) {
        Freq upperFence = new Freq((double) 0);
        upperFence.setHzValue(medianRight.getHzValue()+1.5* iqr.getHzValue());
        return upperFence;
    }

    public static Freq getLowerFence(Freq medianLeft, Freq iqr) {
        Freq lowerFence = new Freq((double) 0);
        lowerFence.setHzValue(medianLeft.getHzValue()-1.5* iqr.getHzValue());
        return lowerFence;
    }


}
