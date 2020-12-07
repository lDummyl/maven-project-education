package task1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import task4.JsonReady;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;
@JsonAutoDetect
public class BirthDate implements Comparable<BirthDate>, JsonReady {
    LocalDate localBirthDate;
    int year;
    int month;
    int day;

    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public LocalDate getLocalBirthDate() {
        return localBirthDate;
    }

    public BirthDate(LocalDate localBirthDate) {
        this.localBirthDate = localBirthDate;
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

    public void setLocalBirthDate(LocalDate localBirthDate) {
        this.localBirthDate = localBirthDate;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate = (BirthDate) o;
        return year == birthDate.year &&
                month == birthDate.month &&
                day == birthDate.day &&
                Objects.equals(localBirthDate, birthDate.localBirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localBirthDate, year, month, day);
    }


    @Override
    public int compareTo(BirthDate o) {
        return this.localBirthDate.compareTo(o.localBirthDate);
    }
}
