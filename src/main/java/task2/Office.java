package task2;

public class Office {

	Secretary secretary;
	Director director;
	Manager manager;
	HR hr;

 /*
 Hr hr;
 */

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void giveList(HR phrase1){
		hr = phrase1;
		System.out.println(hr.phrase1);
	}

	void prepareList(HR phrase2){
		hr = phrase2;
		System.out.println(hr.phrase2);
	}

	void appealDirector(HR phrase3){
		System.out.println(phrase3.phrase3);
	}


	void invitePeople(Secretary human){
		secretary = human;
		System.out.println(secretary.name );
	}

	void chooseDirector(Director human){
		director = human;
		director.firedPeople();
	}

	void listKPI(Manager human) {
		manager = human;
		manager.inputKPI();
	}

	void createTable(HR human){
		human.createTable();
	}

}
