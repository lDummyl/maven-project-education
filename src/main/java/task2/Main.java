package task2;

// Сделать 10 секретарей 1 HR и директора, который
// произвольно выбирает секретаря из предложенных отделом кадров,
// все это происходит в офисе

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
	public static void addPeople(){
		Person johnSmith = new Person("John Smith", "Director");
		Person jackDonovan = new Person("Jack Donovan", "HR Specialist");
		Person janiceGeorge = new Person("Janice George", "Secretary");
		Person jeannieGreer = new Person("Jeannie Greer", "Secretary");
		Person tomFord = new Person("Tom Ford", "Secretary");
		Person geneGlee = new Person("Gene Glee", "Secretary");
		Person rajKapoor = new Person("Raj Kapoor", "Secretary");
		Person cathyHutchinson = new Person("Cathy Hutchinson", "Secretary");
		Person albertCleveland = new Person("Albert Cleveland", "Secretary");
		Person maggyObrien = new Person("Maggie O'Brian", "Secretary");
		Person alexSantino = new Person("Alex Santino", "Secretary");
		Person ruchiFaradj = new Person("Ruchi Faradj", "Secretary");

		ArrayList<Person> people = new ArrayList<>();
		people.add(jackDonovan);
		people.add(johnSmith);
		people.add(janiceGeorge);
		people.add(jeannieGreer);
		people.add(tomFord);
		people.add(geneGlee);
		people.add(rajKapoor);
		people.add(cathyHutchinson);
		people.add(albertCleveland);
		people.add(maggyObrien);
		people.add(alexSantino);
		people.add(ruchiFaradj);
	}
	void invitePeople(ArrayList<Person> people){
		for (Person person : people) {
			if (person.position.equals("Secretary")){
				String selected_last_name=person.name.lastName;
				String selected_first_name=person.name.lastName;
			}
		}
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
class Position {
	String position;
	public Position(String position){
		this.position = position;
	}
}
class Person {
	Name name;
	Position position;
	public Person(String name, String position) {
		String[] nameArr = name.split(" ");
		this.name = new Name(nameArr[0], nameArr[1]);
		this.position = new Position(position);
	}
}