package task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class BirthDate {

    LocalDate localBirthDate;
    int year;
    int month;
    int day;

    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public BirthDate() {
        Random random = new Random();
        while (localBirthDate == null) {
            try {
                this.localBirthDate = LocalDate.of(random.nextInt(70) + 1950, 1 + random.nextInt(11), 1 + random.nextInt(30));
            } catch (Exception e) {
                System.out.println("Invalid Date generated");
            }
        }
    }
}
