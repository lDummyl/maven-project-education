package task1;

public class Age {

    int year;
    int month;
    int day;

    Age(int day, int month, int year) {
        if(day > 0 && day < 32 && month > 0 && month < 13 && year > 0){
        this.day = day;
        this.month = month;
        this.year = year;
        }else{
            throw new RuntimeException("Day, month and year must be positive");
        }
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
