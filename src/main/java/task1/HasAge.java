package task1;

import java.util.List;

public interface HasAge {

    BirthDate getBd();

    default boolean isOlderThan(HasAge other) {
        return this.getBd().before(other.getBd());
    }

    static  HasAge getOldest(List<HasAge> peoples) {
        HasAge oldestPerson = peoples.get(0);
        for (HasAge person : peoples) {
            if (person.isOlderThan(oldestPerson)) {
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }

}
