package task1;

import java.time.LocalDate;
import java.util.*;

public class Name {

    public String firstName;
    public String lastName;

    public Name() {
        this.firstName = names.get(random.nextInt(names.size()));
        this.lastName = lastNames.get(random.nextInt(lastNames.size()));
    }

    public static List<String> names = new ArrayList<>();
    public static List<String> lastNames = new ArrayList<>();
    static Random random = new Random();

    static {
        names.addAll(Arrays.asList("Migel", "Mark", "Berger", "Johan", "Laser", "Mohamed", "Jack", "Gilbert"));
        for (String name : names) {
            lastNames.add(name + "son");
        }
//        8*8 = 64
    }

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
