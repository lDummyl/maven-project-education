package task2;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// TODO: 5/22/20 этот класс живет в 1й таске, его ну нужно переносить чтобы использовать
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

}
