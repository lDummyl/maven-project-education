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
        this.day = 1 + random.nextInt(27) ;
//        8 * 8 * 120 * 12 *28
    }

    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public static List<BirthDate> getBirthDates() {
        List<BirthDate> birthDates;
        birthDates = new ArrayList<>();
        birthDates.add(new BirthDate(2001, 11, 5));
        birthDates.add(new BirthDate(1980, 9, 2));
        birthDates.add(new BirthDate(1984, 3, 5));
        birthDates.add(new BirthDate(1990, 6, 7));
        birthDates.add(new BirthDate(1989, 5, 11));
        birthDates.add(new BirthDate(1999, 7, 1));
        birthDates.add(new BirthDate(2002, 8, 2));
        birthDates.add(new BirthDate(2000, 1, 17));
        return birthDates;
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
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
