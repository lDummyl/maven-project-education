package SortingExperiment;

import java.util.Collection;

public interface Ranger<T extends Number & Comparable<T>> {

    AcceptableRange<T> getRange(Collection<T> inputs);

}
