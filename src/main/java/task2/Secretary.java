package task2;

import task1.Name;
import task1.Person;

public class Secretary {

	private Person person;

	public Secretary(Person person) {
		this.person = person;
	}

	// TODO: 5/20/20 старайся не иметь useless методов
	// TODO: 5/20/20 а что сразу удалять мтожно же наоборот использовать
	public void sendMail() {
		System.out.println("Mail has been sent");
	}

	@Override
	public String toString() {
		return "Secretary{" +
				 person +
				'}';
	}
}
