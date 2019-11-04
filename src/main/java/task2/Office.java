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


	// TODO: 11/4/19 ну ладно чтобы было веселей, добавь еще бухгалтера, охранника и юриста
	public Office() {
		this.hr.setOffice(this);
		this.director.setOffice(this);
	}

	public void inviteToAudition(Person person){
		List<Person> passed = hr.examinePerson(person);
		secretary = director.chooseCandidate(passed);
		if (secretary != null)secretary.setOffice(this);// TODO: 11/3/19  :) логики в офисе быть не должно, офис не принимает решений, подумай еще

	}

	public Secretary getSecretary() {
		return secretary;
	}

}
