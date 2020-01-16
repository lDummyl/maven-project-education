package task2;

import java.util.List;
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
		// TODO: 1/8/20 теперь попробуй сделать так. Диретор не будет выбирать из одного акндидата, поэтому пока у хр в папочке не будет
		//  5ти претедентов серетаря не наймут. При этом директор не лох, он выберет лучшего по КПЙ.

		// TODO: 1/16/20 ты реализовала выдачу премий, здесь же аналогичная задача но результат выбор директором назначенца на пост секретаря
		//  вот тебе подсказка.
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
		System.out.println(hr.phrase2);
		System.out.println("");
		System.out.println(hr.phrase3);
		hr.createTable(kpis);

		director.giveBonus(kpis);
	}
}
