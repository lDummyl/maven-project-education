package task1;


import java.util.*;

public class Main {

	public static void main(String[] args) {
		first();
		second();

	}

	public static void first(){
		// TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

		Age age0 = new Age(1995,06,12);
		Name name0 = new Name("Olga ", "Petrova");
		Person person0 = new Person(name0, age0);

		Age age1 = new Age(1994,05,11);
		Name name1 = new Name("Victor ", "Nabokov");
		Person person1 = new Person(name1, age1);

		Age age2 = new Age(1993,04,10);
		Name name2 = new Name("Semen ", "Ylyich");
		Person person2 = new Person(name2, age2);

		Age age3 = new Age(1992,03,9);
		Name name3 = new Name("Anna ", "Ivanova");
		Person person3 = new Person(name3, age3);

		Age age4 = new Age(1991,02,8);
		Name name4 = new Name("Maria", "Torova");
		Person person4 = new Person(name4, age4);

		Map<Age, Name> persons = new HashMap<Age, Name>() {{
			put(age0, name0);
			put(age1, name1);
			put(age2, name2);
			put(age3, name3);
			put(age4, name4);
		}};
		ArrayList<Name> winners = new ArrayList<>();
		Name name = null;
		int min =  2020;

		for (Map.Entry<Age, Name> person : persons.entrySet()) {

			Age ages = person.getKey();      //создаем переменную ages, в которую кладем age0,age1,...
			int year = ages.year;            //создаем переменную year, в которую кладем год из age0,age1,...

			if (year < min){
				min = year;
				name = person.getValue();  //когда наименьший год, то запоминаем имя
			}
			winners.add(name);
		}
		System.out.println(winners);
	}

	public static void second(){
		// TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

	}

}

class Name {

	String firstName;
	String lastName;

	Name(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

}

class Age {

	int year;
	int month;
	int day;

	Age(int year, int month, int day){
		this.day = day;
		this.month = month;
		this.year = year;
	}

}

class Person {

	Name name;
	Age age;

	Person(Name name, Age age){
		this.name = name;
		this.age = age;
	}
}