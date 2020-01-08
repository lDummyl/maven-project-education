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


	void invitePeople(Secretary human){
		manager.inputKPI(human);
		secretary = human;
		//System.out.println(secretary.name );
	}

	void chooseDirector(Director human){
		director = human;
	}

	void createTable(){
		Map<String, Double> kpis = manager.kpis;
		System.out.println(hr.phrase2);
		System.out.println("");
		System.out.println(hr.phrase3);
		hr.createTable(kpis);
	}

	public void inviteManager(Manager manager) {
		this.manager = manager;
	}

	public void applyBonus() {
		Map<String, Double> kpis = manager.kpis;
		director.giveBonus(kpis);
	}
}
