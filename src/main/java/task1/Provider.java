package task1;

import java.util.ArrayList;
import java.util.List;

public interface Provider {

    HasAge provide();

    default List<HasAge> provide(int qty) {
        ArrayList<HasAge> people = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
             people.add(provide());
        }
        return people;
    }
}
