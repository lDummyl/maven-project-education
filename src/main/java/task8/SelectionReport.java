package task8;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class SelectionReport {

    public List<TechnicalUnit> technicalUnits = new ArrayList<>();
    public CommercialUnit commercialUnit;
    public transient Integer errors; // не уверен что это верное решение "transient"
}
