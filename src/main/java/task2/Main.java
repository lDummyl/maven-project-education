package task2;

// Сделать 10 секретарей 1 HR и директора, который
// произвольно выбирает секретаря из предложенных отделом кадров,
// все это происходит в офисе

import task1.Birthday;
import task1.Name;
import task1.Person;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {

	}
	static class GenerateRandom {
		public void random_number() {
			Random rand = new Random(); //instance of random class
			int upperbound = 8;
			//generate random values from 1-8
			int int_random = rand.nextInt(upperbound);
			double double_random=rand.nextDouble();
			float float_random=rand.nextFloat();
		}
	}
	public static void addPeople() {
//		Person johnSmith = new Person("John Smith", 1, 1, 1960);
//		Person jackDonovan = new Person("Jack Donovan", 2, 2, 1970);
//		Person janiceGeorge = new Person("Janice George", 3, 3, 1971);
//		Person jeannieGreer = new Person("Jeannie Greer", 4, 4, 1972);
//		Person tomFord = new Person("Tom Ford", 5, 5, 1973);
//		Person geneGlee = new Person("Gene Glee", 6, 6, 1974);
//		Person rajKapoor = new Person("Raj Kapoor", 7, 7, 1975);
//		Person cathyHutchinson = new Person("Cathy Hutchinson", 8, 8, 1976);
//		Person albertCleveland = new Person("Albert Cleveland", 9, 9, 1977);
//		Person maggyObrien = new Person("Maggie O'Brian", 10, 10, 1978);
//		Person alexSantino = new Person("Alex Santino", 11, 11, 1978);
//		Person ruchiFaradj = new Person("Ruchi Faradj", 12, 12, 1979);
//
//		ArrayList<Person> people = new ArrayList<>();
//		people.add(jackDonovan);
//		people.add(johnSmith);
//		people.add(janiceGeorge);
//		people.add(jeannieGreer);
//		people.add(tomFord);
//		people.add(geneGlee);
//		people.add(rajKapoor);
//		people.add(cathyHutchinson);
//		people.add(albertCleveland);
//		people.add(maggyObrien);
//		people.add(alexSantino);
//		people.add(ruchiFaradj);
	}
}

class Employee extends Person {
	private String position;

	Employee() {
		super();
	}

	public Employee(String secretary) {
//		Employee jackDonovan = new Employee("secretary");
//		jackDonovan.name = new Name("Jack","Donovan");
//		jackDonovan.birthday = new Birthday(1970, 2, 2);
//		jackDonovan.position = "secretary";
//
//		Employee janiceGeorge = new Employee("secretary");
//		jackDonovan.name = new Name("Janice","George");
//		jackDonovan.birthday = new Birthday(1971, 3, 3);
//		jackDonovan.position = "secretary";
//
//
//		Employee jeannieGreer = new Employee("secretary");
//		jackDonovan.name = new Name("Jeannie","Greer");
//		jackDonovan.birthday = new Birthday(1972, 4, 4);
//		jackDonovan.position = "secretary";
//
//		ArrayList<Employee> employees = new ArrayList<>();
//		employees.add(jackDonovan);
//		employees.add(janiceGeorge);
//		employees.add(jeannieGreer);
//		employees.add(johnSmith);


	}

	public static void main(String[] args) {
		Employee jimBarnes = new Employee("secretary");
		jimBarnes.name = new Name("Jim", " Barnes");
		jimBarnes.birthday = new Birthday(1970, 1, 1);
		jimBarnes.position = "secretary";
		System.out.printf(jimBarnes.position);

		Employee johnSmith = new Employee("secretary");
		johnSmith.name = new Name("John", " Smith");
		johnSmith.birthday = new Birthday(1970, 1, 1);
		johnSmith.position = "secretary";
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(jimBarnes);
		employees.add(johnSmith);
	}
//	public static void addPeople() {
//		// 1. Container type (it can be interface or a class)
//		// 2. Variable name
//		// 3. Assignment operator
//		// 4. Object creation operator 5.
//		// Class constructor call
//		Employee johnSmith = new Employee("secretary");
//		// STILL CANNOT DO THE FOLLOWING :-(
//		johnSmith.name = new Name("John"," Smith");
//		johnSmith.birthday = new Birthday(1970, 1, 1);
//		// johnSmith.position = "secretary";
//		//"John Smith",1,1,1960, "Secretary");
//
//	}
}