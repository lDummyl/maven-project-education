package SortingExperiment;

import java.util.ArrayList;

public class RemovePoint {
    public ArrayList<Point> removeBadPoints(ArrayList<Point> points, ArrayList<Double> d) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < d.size(); j++) {
                if (points.get(i).frequency.equals(d.get(j))) {
                    points.remove(i);
                }
            }
        }
        return points;
    }
}
