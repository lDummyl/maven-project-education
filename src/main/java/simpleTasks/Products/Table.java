package simpleTasks.Products;

import java.util.HashSet;
import java.util.Set;

public class Table {
    int maxQuantityOfPlates;
    Set<Plate> setOfPlates = new HashSet<>();

    public void putPlate(Plate plate){
        if(setOfPlates.size() < maxQuantityOfPlates){
            setOfPlates.add(plate);
        }
    }
}

