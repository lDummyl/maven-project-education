package task1;


import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO: 7/15/20 hi from outside
		first();
		second();

	}



	public static void first(){
		// TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
		ArrayList<Person> people = new ArrayList<>();


		Person иванПетров = new Person("Иван Петров", 13, 8, 1956);
		people.add(иванПетров);
		people.add(new Person("Иван Иванов", 12, 5, 1985));
		people.add(new Person("Иван Иванов", 12, 5, 1915));

		Person oldestPerson = people.get(0);
		for (Person person : people) {
			boolean answer =  oldestPerson.isOlderThan(person);
			if (!answer) {
				oldestPerson = person;
			}
		}
		Name name = new Name("a", "b");
		System.out.println(oldestPerson.birthDate.year);


	}

	public static void second(){
		// TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

	}

}

@ToString
@AllArgsConstructor
class Name {

	String firstName;
	String lastName;


}

class BirthDate {

	int year;
	int month;
	int day;
	LocalDate localDate;

	public BirthDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		localDate = LocalDate.of(year, month ,day)
	}

	public boolean earlyThan(BirthDate birthDate) {
		return this.localDate.isBefore(birthDate.localDate)
		//return this.year< birthDate.year;
	}
}

class Person {

	Name name;
	BirthDate birthDate;


	public Person(String name, int day, int month, int year) {
		birthDate = new BirthDate(day, month, year);
		// TODO: 15.07.2020 implement
	}

	public boolean isOlderThan(Person person) {
		return this.birthDate.earlyThan(person.birthDate);
	}
}