package task1;

import java.util.List;

public interface HasAge {

    BirthDate getBd();

    default boolean isOlderThan(HasAge other) {
        return this.getBd().before(other.getBd());
    }

    static <T extends HasAge> T getOldest(List<T> peoples) {
        T oldestPerson = peoples.get(0);
        for (T person : peoples) {
            if (person.isOlderThan(oldestPerson)) {
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }

}
