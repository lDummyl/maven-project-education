package task2;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BirthDate {
    public int year;
    public int month;
    public int day;


    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public static List<BirthDate> birthDates;

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

}
