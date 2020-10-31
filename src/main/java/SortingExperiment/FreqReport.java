package SortingExperiment;

import java.util.*;
import java.util.stream.Collectors;

public class FreqReport {

    List<Point> pointList;
    private List<Point> badPointList;

    private List<Freq> freqList;

    List<Freq> lefts;
    List<Freq> right;

    Freq medianLeft;
    Freq medianRight;

    Freq upperFence;
    Freq lowerFence;

    Freq iQR;


    public FreqReport(List<Point> pointList) {
        this.pointList = pointList;
    }



    public void setField(){
        this.freqList = pointList.stream().map(Point::getFrequency).collect(Collectors.toList());
        this.lefts = FreqReportCalculations.getLeft(this.freqList);
        this.right = FreqReportCalculations.getLeft(this.freqList);

        this.medianLeft = FreqReportCalculations.getMedian(lefts);
        this.medianRight = FreqReportCalculations.getMedian(right);

        this.iQR = FreqReportCalculations.getIQR(medianRight, medianLeft);

        this.upperFence = FreqReportCalculations.getUpperFence(medianRight,iQR);
        this.lowerFence = FreqReportCalculations.getLowerFence(medianLeft,iQR);
        this.lowerFence = FreqReportCalculations.getLowerFence(medianLeft,iQR);
    }

    public List<Freq> getBadPoints() {
        List<Freq> badPointsList = new ArrayList<>();
        for (Freq freq :
                freqList) {
            if (freq.getHzValue() > this.upperFence.getHzValue() || freq.getHzValue() < this.lowerFence.getHzValue()) {
                badPointsList.add(freq);
                System.out.println(freq.getHzValue());
            }
        }
        //     throw new RuntimeException("");
        return badPointsList;

        // TODO: 14.10.2020 calculate

    }

}
