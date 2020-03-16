package task2.oldOffice;

import java.util.List;
import java.util.Map;

public class Office {

	// TODO: 1/17/20 в зависимости от того какое значение используется мы либо запрашиваем данные из консоли либо подмахиваем
	//  их сами рандомно, скорей всего у тебя не получится это сделать, но я хочу посмотреть на твой best shot, удачи.
	enum Mode{
		CONSOLE,
		RANDOM;
	}

	public Office(Mode mode) {
		this.mode = mode;
	}

	final Mode mode;
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
		List<Secretary> candidates = hr.conciderCandidate(human);
		Secretary chosenOne = director.chooseCandidate(candidates);
		if(chosenOne != null){
			secretary = chosenOne;
		}
	}

	void invite(Director human){
		director = human;
	}

	public void invite(Manager manager) {
		this.manager = manager;
	}

	 void startWorkDay(){
		Map<String, Double> kpis = manager.kpis;
		Map<String, Integer> expYears = manager.expYears;

		System.out.println(hr.phrase2);
		System.out.println("");
		System.out.println(hr.phrase3);   // фраза: "Mr Director, check this table with employee's KPI:"
		hr.createTable(kpis, expYears);
		director.giveBonus(kpis);


	}


}
