package task1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;

public class BirthDate {

    private static final LocalDate minDate = LocalDate.of(1910, 1, 1);
    private static final LocalDate maxDate = LocalDate.of(2019, 12, 31);
    protected static final int MIN_AGE = 18;
    protected static final int MAX_AGE = 120;
    int year;
    int month;
    int day;
    LocalDate localDate;
    private Random randomNumber;


    public BirthDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.localDate = LocalDate.of(year, month, day);
    }

    public BirthDate() {
        try {
            this.randomNumber = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        getRandomDate();
    }

    public boolean earlyThan(BirthDate birthDate) {
        return this.localDate.isBefore(birthDate.localDate);
    }

    private BirthDate getRandomDate() {
        //     TODO: 7/23/20 или так, наглядней, и не придется программу переписывать или перезапускать чтобы "стрелки подвести"
        LocalDate minDate = LocalDate.now().minusYears(MIN_AGE);
        LocalDate maxDate = LocalDate.now().minusYears(MAX_AGE);

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
