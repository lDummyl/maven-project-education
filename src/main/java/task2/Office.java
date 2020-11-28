package task2;

import java.util.Optional;

public class Office {

	Director director;

	Hr hr;

	Secretary secretary;
	Lawyer lawyer;
	Security security;
	Accountant firstAccountant;
	Accountant secondAccountant;

	public Office(Director director, Hr hr) {
		this.director = director;
		this.hr = hr;
	}

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат


	void invitePeople(Object human){
		hr.checkEmployee(human);
		Optional<Secretary> optionalSecretary = director.chooseEmployee(hr.getListEmployee(), Secretary.class);
		optionalSecretary.ifPresent(value -> secretary = value);

	}

}
