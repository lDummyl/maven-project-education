package task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class BirthDate {
    public int year;
    public int month;
    public int day;
    static Random random = new Random();

    public BirthDate() {
        this.year = 1900 + random.nextInt(120);
        this.month = 1 + random.nextInt(11);
        this.day = 1 + random.nextInt(27);
//        8 * 8 * 120 * 12 *28
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate = (BirthDate) o;
        return year == birthDate.year &&
                month == birthDate.month &&
                day == birthDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
