package task1;

import java.time.LocalDate;

public class Age {

    int year;
    int month;
    int day;

    public Age(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Age() {
        this(LocalDate.now().minusYears(18));
    }

    public Age(LocalDate localDate) {
        this(localDate.getYear(), localDate.lengthOfMonth(), localDate.getDayOfMonth());
    }

    @Override
    public String toString() {
        return "Age{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
