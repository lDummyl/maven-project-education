package task2;

import java.util.List;

public class Office {

	/*
	Secretary secretary;

	Director director;

	Hr hr;
	*/

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	private Director director = new Director();
	private Hr hr = new Hr();
	private Secretary secretary;

	public void inviteToAudition(Person person){
		List<Person> passed = hr.examinePerson(person);
		if (secretary == null) {
			secretary = director.chooseCandidate(passed);
		} else {
			System.out.println("В офисе уже есть секретарь - " + secretary.getName());
		}
	}

	public Secretary getSecretary() {
		return secretary;
	}

}
