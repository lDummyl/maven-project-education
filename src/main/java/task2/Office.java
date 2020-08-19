package task2;

public class Office {

	Director director;

	Hr hr;

	Secretary secretary;
	public Office(Director director, Hr hr) {
		this.director = director;
		this.hr = hr;
	}

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeople(Object human){
		hr.invite(human);
		secretary = (Secretary) director.getEmployee();
	}
}
