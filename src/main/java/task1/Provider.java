package task1;

import java.util.ArrayList;
import java.util.List;

public interface Provider<T> {

    T provide();

    default List<T> provide(int qty) {
        ArrayList<T> people = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
             people.add(provide());
        }
        return people;
    }
}
