package task2;

// Сделать 10 секретарей 1 HR и директора, который
// произвольно выбирает секретаря из предложенных отделом кадров,
// все это происходит в офисе

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
		Person johnSmith = new Person("John Smith", 1, 1, 1960);
		Person jackDonovan = new Person("Jack Donovan", 2, 2, 1970);
		Person janiceGeorge = new Person("Janice George", 3, 3, 1971);
		Person jeannieGreer = new Person("Jeannie Greer", 4, 4, 1972);
		Person tomFord = new Person("Tom Ford", 5, 5, 1973);
		Person geneGlee = new Person("Gene Glee", 6, 6, 1974);
		Person rajKapoor = new Person("Raj Kapoor", 7, 7, 1975);
		Person cathyHutchinson = new Person("Cathy Hutchinson", 8, 8, 1976);
		Person albertCleveland = new Person("Albert Cleveland", 9, 9, 1977);
		Person maggyObrien = new Person("Maggie O'Brian", 10, 10, 1978);
		Person alexSantino = new Person("Alex Santino", 11, 11, 1978);
		Person ruchiFaradj = new Person("Ruchi Faradj", 12, 12, 1979);

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
}

class People extends Person {
	private final String position;

	People() {
		super();
		position = "Secretary";
	}

	public static void addPeople() {
		People johnSmith = new People();
		// STILL CANNOT DO TEH FOLLOWING :-(
		// johnSmith.name = "John Smith";johnSmith.birthday = new Birthday(1970, 1, 1);
		//"John Smith",1,1,1960, "Secretary");

	}