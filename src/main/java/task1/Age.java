package task1;

public class Age {

    int year;
    int month;
    int day;

    Age(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}
