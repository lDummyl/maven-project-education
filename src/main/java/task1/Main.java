package task1;


import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		first();
		second();

	}

	public static void first(){
		// TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
		Person ivanPetrov = new Person("Ivan Petrov", 10, 8, 1956);
		Person ivanIvanov = new Person("Ivan Ivanov", 10, 8, 1946);
		ArrayList<Person> people = new ArrayList<>();
		people.add(ivanPetrov);
		people.add(ivanIvanov);
		people.add(new Person("Phil Donohue",10, 3,1940));
		people.add(new Person("Samantha Hoover",11, 7,1990));
		Person oldest = people.get(0);
		for (Person person : people) {
			if (oldest.birthday.after(person.birthday)) {
				oldest = person;
			}
		}
		System.out.println(oldest.name.lastName);
	}


	public static void second(){
		// TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

	}

}

class Name {

	String firstName;
	String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

class Birthday {

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



class Person {

	Name name;
	Birthday birthday;

	public Person(String name, int day, int month, int year) {
		String[] nameArr = name.split(" ");
		this.name = new Name(nameArr[0], nameArr[1]);
		birthday = new Birthday(year, month, day);
	}
}