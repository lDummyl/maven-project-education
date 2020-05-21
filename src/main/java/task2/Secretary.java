package task2;

import task1.Person;

public class Secretary extends OfficeWorker{
	// TODO: 5/20/20 эти поля характерны только для Секретарей или можно вынести в какой-то родительский класс?

	public Secretary(String fName, String lName, int skill) {

		this.fName = fName;
		this.lName = lName;
		this.skill = skill;
	}

//	public Secretary(Person person) {
//		this(person.name)
//	}


	// TODO: 5/20/20 старайся не иметь useless методов
	// TODO: 5/20/20 а что сразу удалять мтожно же наоборот использовать
	public void sendMail() {
		System.out.println("Mail has been sent");
	}


	@Override
	public String toString() {
		return "Secretary{" +
				"fName='" + fName + '\'' +
				", lName='" + lName + '\'' +
				", skill=" + skill +
				'}';
	}
}
