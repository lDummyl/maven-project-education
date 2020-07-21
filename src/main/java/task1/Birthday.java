package task1;

import java.time.LocalDate;

public class Birthday {

	int year;
	int month;
	int day;

	public Birthday(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public boolean after(Birthday birthday) {
		LocalDate thisBirthday = LocalDate.of(this.year, this.month, this.day);
		LocalDate currBirthday = LocalDate.of(birthday.year, birthday.month, birthday.day);
		return thisBirthday.isAfter(currBirthday);
	}
}
