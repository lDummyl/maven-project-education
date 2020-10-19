package SortingExperiment;


import java.util.ArrayList;
import java.util.Collections;

public class Showene {
    public void makeShoweneTest(ArrayList points) {
        /*ArrayList<Freq> frequencies = new ArrayList<>();
        for (Point p : points) {
            frequencies.add(p.frequency);
        }
        int middle = frequencies.size() / 2;

        ArrayList<Freq> left = new ArrayList<>();
        ArrayList<Freq> right = new ArrayList<>();

        Collections.sort(frequencies);

        for (int i = 0; i < middle; i++) {
            left.add(frequencies.get(i));
        }

        for (int i = middle; i < frequencies.size(); i++) {
            right.add(frequencies.get(i));
        }

        Freq medFreqLeft = Freq.getMedian(left);
        Freq medFreqRight = Freq.getMedian(right);



        Double iQR = medFreqRight.hzValue - medFreqLeft.hzValue;

        Double lowerFence = medFreqLeft.hzValue - 1.5 * iQR;
        Double upperFence = medFreqRight.hzValue + 1.5 * iQR;


        System.out.println(lowerFence);
        System.out.println(upperFence);

        ArrayList<Double> badPoints = new ArrayList<>();
        for (Freq d :
                frequencies) {
            if (d.hzValue > upperFence || d.hzValue < lowerFence) {
                badPoints.add(d.hzValue);
                System.out.println(d);
            }
        }
   //     throw new RuntimeException("");
        return badPoints;

        */
    }

}
