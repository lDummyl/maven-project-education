package PointFiltration.Showene;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeftAndRight {

    List<Double> lefts;
    List<Double> rights;

    public LeftAndRight(List<Double> doubles) {
        this.lefts = makeLeft(doubles);
        this.rights = makeRight(doubles);
    }

    public List<Double> getLefts() {
        return lefts;
    }

    public List<Double> getRights() {
        return rights;
    }

    public List<Double> makeLeft(List<Double> doubles) {
        ArrayList<Double> lefts = new ArrayList<>();
        for (int i = 0; i < doubles.size() / 2; i++) {
            lefts.add(doubles.get(i));
        }
        return lefts;
    }

    public List<Double> makeRight(List<Double> doubles) {
        ArrayList<Double> rights = new ArrayList<>();
        for (int i = (doubles.size() / 2) + 1; i < doubles.size(); i++) {
            rights.add(doubles.get(i));
        }
        return rights;
    }


}
