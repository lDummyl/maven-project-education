package task1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Setter
@Getter
@EqualsAndHashCode
public class BirthDate implements Comparable<BirthDate> {
    private LocalDate localBirthDate;
    private int year;
    private int month;
    private int day;

    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public BirthDate() {
        Random random = new Random();
        while (localBirthDate == null) {
            try {
                this.localBirthDate = LocalDate.of(1950 + random.nextInt(70), 1 + random.nextInt(11), 1 + random.nextInt(30));
            } catch (Exception e) {
                //  System.out.println("Invalid date generated");
            }
        }
    }

    @Override
    public int compareTo(BirthDate o) {
        return this.localBirthDate.compareTo(o.localBirthDate);
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "localBirthDate=" + localBirthDate +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
