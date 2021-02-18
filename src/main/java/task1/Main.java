package task1;


import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	static List<String> names = Arrays.asList("Ivan", "Pyotr", "Clement");
	static List<String> lastNames = Arrays.asList("Sidorov", "Konev", "Voroshilov");
	private static Random random = new Random();
	static LocalDate start = LocalDate.of(1900, Month.JANUARY, 1);


	public static void main(String[] args) {
		first();
		second();
	}

	public static void first() {
		// TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

	}

	public static void second() {
		// TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
		final int qty = 5;
		List<Person> list = Stream.generate(Main::getPerson).limit(qty).collect(Collectors.toList());
		Optional<Person> person = list.stream()
				.min(Comparator.<Person>comparingInt(i -> i.age.year)
						.thenComparingInt(i -> i.age.month)
						.thenComparingInt(i -> i.age.day));
		person.ifPresent(System.out::println);
		System.out.println("list = " + list);
	}

	private static Person getPerson() {

		Person person = new Person();
		long days = ChronoUnit.DAYS.between(start, LocalDate.now());
		LocalDate randomDate = start.plusDays(random.nextInt((int) days + 1));
		person.age = new Age(randomDate.getYear(), randomDate.getMonthValue(), randomDate.getDayOfMonth());
		person.name = new Name(names.get(random.nextInt(names.size())), lastNames.get(random.nextInt(lastNames.size())));
		return person;

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

class BirthDate {

	int year;
	int month;
	int day;
	public Age(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

}


class Person {
	Name name;
	BirthDate birthDate;

	@Override
	public String toString() {
		return Stream.of(name.firstName, name.lastName, age.year, age.month, age.day)
				.map(Objects::toString).collect(Collectors.joining(" "));
	}

}