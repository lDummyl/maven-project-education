package newTask1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Random;

public class BirthDate {
    public static final int lowerYear = 1700;
    LocalDate localBirthDate;

    Random random = new Random();

    public BirthDate(Integer year, Integer month, Integer day) {

        try {
            this.localBirthDate = LocalDate.of(year,month,day);
        } catch (DateTimeException e) {
            System.out.println("No such date exits");
        }

    }

    public BirthDate() {
        try {
            this.localBirthDate = LocalDate.of(lowerYear + random.nextInt(), 1+random.nextInt(11), 1+ random.nextInt(30));
        } catch (DateTimeException e) {
            System.out.println("Wrong date generated");
        }
    }

    public LocalDate getLocalBirthDate() {
        return localBirthDate;
    }
}
