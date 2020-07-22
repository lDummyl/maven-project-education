package task1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Random;

public class BirthDate {

    int year;
    int month;
    int day;
    LocalDate localDate;
    private Random randomNumber;
    private static final LocalDate minDate = LocalDate.of(1910, 1,1);
    private static final LocalDate maxDate = LocalDate.of(2019, 12, 31);


    public BirthDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.localDate = LocalDate.of(year, month, day);
    }

    public boolean earlyThan(BirthDate birthDate) {
        return this.localDate.isBefore(birthDate.localDate);
    }

    public BirthDate() {
        try {
            this.randomNumber = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        getRandomDate();
    }

    private BirthDate getRandomDate() {
        int minDay = (int) minDate.toEpochDay();
        int maxDay = (int) maxDate.toEpochDay();
        long randomDate = minDay + randomNumber.nextInt(maxDay - minDay);
        this.localDate = LocalDate.ofEpochDay(randomDate);
        return this;
    }

    @Override
    public String toString() {
        return localDate + "";
    }
}
