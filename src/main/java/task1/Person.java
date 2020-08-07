package task1;

import lombok.ToString;

@ToString
public class Person {

	public String name;
	Birthday birthday;

	public Person(String name, int day, int month, int year) {
		String[] nameArr = name.split(" ");
		this.name = new Name(nameArr[0], nameArr[1]);
		this.birthday = new Birthday(year, month, day);
	}

	public Person() {
		name = new Name();
		birthday = new Birthday();
	}

}
