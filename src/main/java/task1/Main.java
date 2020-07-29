package task1;


import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		first();
		second();
//		SomeObj a = new SomeObj();
//		SomeObj b = new SomeObj();
//		System.out.println("a.hashCode() = " + a.hashCode());
//		System.out.println("b.hashCode() = " + b.hashCode());
//		boolean equals = a.equals(b);
//		System.out.println("equals = " + equals);
//		System.out.println(a == b);

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
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			people.add(new Person());
			System.out.println(i + " " + "added: " + people.get(i).birthday.day);

		}
//		System.out.println("people = " + people);
	}
}

//class SomeObj{
//
//	String name;
//	String rank;
//
//	@Override
//	public int hashCode() {
//		return 42;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		return true;
//	}
//}

