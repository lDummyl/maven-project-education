package SortingExperiment;

public class AcceptableRange<T extends Comparable<T>> {

    T upperBound;
    T lowerBound;

    public AcceptableRange(T upperBound, T lowerBound) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }
}
