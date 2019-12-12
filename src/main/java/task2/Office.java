package task2;

import java.util.Map;

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

	void inviteHr(HR hr){
		this.hr = hr;
		System.out.println(this.hr.phrase1);
	}

	void prepareList(HR phrase2){
		hr = phrase2;
		System.out.println(hr.phrase2);
	}

	void appealDirector(HR phrase3){
		System.out.println(phrase3.phrase3);
	}


	void invitePeople(Secretary human){
		manager.inputKPI(human);
		secretary = human;
		System.out.println(secretary.name );
	}

	void chooseDirector(Director human){
		director = human;
		director.firedPeople();
	}

	void createTable(){
		Map<String, Double> kpis = manager.kpis;
		hr.createTable(kpis);
	}

	public void inviteManager(Manager manager) {
		this.manager = manager;
	}
}
