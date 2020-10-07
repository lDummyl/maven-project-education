package SortingExperiment;

import java.util.ArrayList;
import java.util.Collections;

public class Showene {
    public ArrayList makeShoweneTest(ArrayList<Point> points) {
        ArrayList<Double> doubles = new ArrayList<>();
        for (Point p : points) {
            doubles.add(p.frequency);
        }
        int middle = doubles.size() / 2;

        ArrayList<Double> left = new ArrayList<>();
        ArrayList<Double> right = new ArrayList<>();

        Collections.sort(doubles);

        for (int i = 0; i < middle; i++) {
            left.add(doubles.get(i));
        }

        for (int i = middle; i < doubles.size(); i++) {
            right.add(doubles.get(i));
        }
        Double medianLeft = getMedian(left);
        Double medianRight = getMedian(right);

        Double iQR = medianRight - medianLeft;


        Double lowerFence = medianLeft - 1.5 * iQR;
        Double upperFence = medianRight + 1.5 * iQR;

        System.out.println(lowerFence);
        System.out.println(upperFence);

        ArrayList<Double> badPoints = new ArrayList<>();
        for (Double d :
                doubles) {
            if (d > upperFence || d < lowerFence) {
                badPoints.add(d);
                System.out.println(d);
            }
        }
        return badPoints;
    }

    public Double getMedian(ArrayList<Double> d) {
        int sum = 0;
        for (Double doub :
                d) {
            sum += doub;
        }
        Double median = Double.valueOf(sum / d.size());
        return median;
    }
}
