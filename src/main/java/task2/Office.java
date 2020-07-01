package task2;

import java.util.ArrayList;
import java.util.Random;

public class Office {

	Secretary secretary;
	Director director;
	Hr hr;
	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeaople(Object human) {
		hr.invitePeople(human);
		director.takeForJobe();
	}
}

class Director {
	private Office office;
	private int number = 10;	// - достаточное количество кондидатов директору для выбора одного
	ArrayList <Secretary> candidates = new ArrayList<>();	// - список кондидатов, попавших на собеседование

	Director(Office office) {
		this.office = office;
	}

	public int getNumber() {
		return number;
	}

	public void takeForJobe() {
		if ((office.secretary == null) && (number == candidates.size())) {
			office.secretary = candidates.get(new Random().nextInt(candidates.size()));
			System.out.println(office.secretary.toString() + " was been chosen on the position of a secretary.");
		}
	}
}

class Hr {
	private Office office;

	Hr(Office office) {
		this.office = office;
	}

	void invitePeople(Object human) {
		if (human.getClass() == Secretary.class) {
			Secretary secretary = (Secretary) human;
			if (!office.director.candidates.contains(secretary)) {
				if (office.director.getNumber() > office.director.candidates.size()) {
					office.director.candidates.add(secretary);
				} else {
					System.out.println("The position of a secretary has been filled.");
				}
			}
		}
	}
}

class Secretary {
	Name name = new Name();

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if ((this == null) && (getClass() != obj.getClass())) return false;
		Secretary secretary = (Secretary) obj;
		if (secretary.name.firstName.equals(name.firstName) == false) return false;
		return secretary.name.lastName.equals(name.lastName);
	}

	@Override
	public int hashCode() {
		int result = name.firstName.hashCode();
		result = result * 31 + name.lastName.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return name.firstName + " " + name.lastName;
	}
}

class Name {
	static ArrayList<String> firstNames = new ArrayList<>();
	static ArrayList<String> lastNames = new ArrayList<>();

	static {
		firstNames.add(0, "Anton");
		firstNames.add(1, "Artem");
		firstNames.add(2, "Alexandr");
		firstNames.add(3, "Vladislav");
		firstNames.add(4, "Sergey");
		firstNames.add(5, "Alexey");
	}

	static {
		lastNames.add(0, "Sivochalov");
		lastNames.add(1, "Verenitcin");
		lastNames.add(2, "Strelka");
		lastNames.add(3, "Dubchenko");
		lastNames.add(4, "Beloborodov");
		lastNames.add(5, "Terehov");
		lastNames.add(6, "Belov");
		lastNames.add(7, "Pissarev");
		lastNames.add(8, "Rogalev");
		lastNames.add(9, "Vdiev");
	}

	String firstName;
	String lastName;

	public Name() {
		Random random = new Random();
		this.firstName = firstNames.get(random.nextInt(firstNames.size()));
		this.lastName = lastNames.get(random.nextInt(lastNames.size()));
	}
}