package task1;


import lombok.AllArgsConstructor;
import lombok.ToString;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	static String[] firstNames = {"Ivan", "Petr", "Andrey", "Evgeny"};
	static String[] lastNames = {"Ivanov", "Petrov", "Andreev", "Sidorov"};
	static int numberOfUniqNames = firstNames.length * lastNames.length;

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
		System.out.println(oldestPerson.birthDate.year);


	}

	public static void second(){
		// TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
		ArrayList<Person> peoples = new ArrayList<>();
		while (peoples.size() <= numberOfUniqNames) {
			peoples.add(new Person(generateName(), generateBirthDate()));
		}
		for (Person people : peoples) {
			System.out.println(people);
		}
	}


	private static BirthDate generateBirthDate() {
		Random r = new Random();
		return new BirthDate(r.nextInt(30) + 1, r.nextInt(11) + 1, r.nextInt(110) + 1910);
	}

	private static Name generateName() {
		Random r = new Random();
		return new Name(firstNames[r.nextInt(firstNames.length)],
				lastNames[r.nextInt(lastNames.length)]);
	}

}

@ToString
@AllArgsConstructor
class Name {

	String firstName;
	String lastName;

}
@ToString
class BirthDate {

	int year;
	int month;
	int day;
	LocalDate localDate;

	public BirthDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		localDate = LocalDate.of(year, month ,day);
	}

	public boolean earlyThan(BirthDate birthDate) {
		return this.localDate.isBefore(birthDate.localDate);
	}
}
@ToString
class Person {

	Name name;
	BirthDate birthDate;


	public Person(String name, int day, int month, int year) {
		birthDate = new BirthDate(day, month, year);
		// TODO: 15.07.2020 implement
	}

	public Person(Name name, BirthDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public boolean isOlderThan(Person person) {
		return this.birthDate.earlyThan(person.birthDate);
	}
}