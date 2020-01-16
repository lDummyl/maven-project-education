package task2;

import java.util.Map;

public class Office {

	Secretary secretary;
	Director director;
	Manager manager;
	HR hr;

	void invite(HR hr) {
		this.hr = hr;
		System.out.print(this.hr.phrase0);
	}

	void invite(HR hr, int inEmployees){
		System.out.println(this.hr.createPhrase1(inEmployees));
	}


	void invite(Secretary human){
		manager.inputKPI(human);
		secretary = human;

	}

	void invite(Director human){
		director = human;
	}



	public void invite(Manager manager) {
		this.manager = manager;
	}

	 void startWorkDay(){
		Map<String, Double> kpis = manager.kpis;
		System.out.println(hr.phrase2);
		System.out.println("");
		System.out.println(hr.phrase3);
		hr.createTable(kpis);

		Director.giveBonus(kpis);
	}
}
