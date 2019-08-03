package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;





public class Office {

	Secretary secretary;
	Director director = new Director(this);
	Hr hr = new Hr("Аделаида Марковна");

	void invitePeople(Object human) {      //претенденты приходят по одному
		if (human instanceof WantAWork) {
			List<WantAWork> currentCandidates = hr.considerCandidate((WantAWork) human);
			secretary = director.chooseSecretary(currentCandidates);
		}
	}
}

class Secretary implements WantAWork {

	String name;

	public Secretary(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Секретарь " + name;
	}

	@Override
	public boolean passInterview() {
		return true;
	}
}


class Director {

	final Office myOffice;
	final int enoughCandidatesToDecide = 4;
	Random random = new Random();

	public Director(Office myOffice) {
		this.myOffice = myOffice;
	}

	public Secretary chooseSecretary(List<WantAWork> currentCandidates) {
		if (currentCandidates.size() < enoughCandidatesToDecide) return null;
		WantAWork wantAWork = currentCandidates.get(random.nextInt(currentCandidates.size()));
		if (wantAWork instanceof Secretary) {
			return (Secretary) wantAWork;
		} else {
			throw new RuntimeException("Что это вы, "+ myOffice.hr.name +",  мне подсовываете " + wantAWork.getClass() + " вместо " + Secretary.class);
		}
	}
}

class Hr{

	List<WantAWork> listJobSeekers = new ArrayList<>();

	String name;

	public Hr(String name) {
		this.name = name;
	}

	public List<WantAWork> considerCandidate(WantAWork candidate) {
		if (candidate.passInterview()) {
			listJobSeekers.add(candidate);
		}
		return listJobSeekers;
	}
}