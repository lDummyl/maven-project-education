package CollectionWork;

import task1.BirthDate;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class BirtDate implements Comparable<BirtDate> {
    LocalDate localBirthDate;

    public BirtDate(LocalDate birthDate) {
        this.localBirthDate = birthDate;
    }

    public BirtDate() {
        Random random = new Random();
        while (localBirthDate == null) {
            try {
                this.localBirthDate = LocalDate.of(1970 + random.nextInt(70), 1 + random.nextInt(11), 1 + random.nextInt(30));
            } catch (Exception e) {
                System.out.println("Invalid Date");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirtDate birtDate = (BirtDate) o;
        return Objects.equals(localBirthDate, birtDate.localBirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localBirthDate);
    }

    @Override
    public int compareTo(BirtDate o) {
            return this.localBirthDate.compareTo(o.localBirthDate);
    }
}
