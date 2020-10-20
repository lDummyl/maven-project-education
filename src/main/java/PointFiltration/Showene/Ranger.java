package PointFiltration.Showene;

import java.util.Collection;

interface Ranger<T extends Number>{


    AcceptableRange<T> getRange(Collection<T> inputs);

}