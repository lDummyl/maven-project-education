package task1;



public class Main {

	public static void main(String[] args) {
		first();
		second();

	}

	public static void first(){
		// TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

	}

	public static void second(){
		// TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

	}

}

class Name {

	String firstName;
	String lastName;

}

class BirthDate {

	int year;
	int month;
	int day;

}

class Person {

	Name name;
	BirthDate birthDate;

}